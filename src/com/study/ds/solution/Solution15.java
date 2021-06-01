package com.study.ds.solution;

public class Solution15 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 2, 4, 6, 3}));
    }

    public static int solution( int[] A ) { // this is the method required for the challenge
        Solution15 solution15 = new Solution15();
        return solution15.calculateMinimumPairSum( A, 1 );
    }

    public int calculateMinimumPairSum( int[] A, int requiredGapBetweenPairs ) {


        // if there are 5 chain links, only the 2nd and 4th are allowed to break -
        // return their sums unconditionally
        if ( A.length == 5 ) {
            return A[ 1 ] + A[ 3 ];
        }


        /*
         *   We must ignore the first and last elements of the input array A - they are the end links of the chain
         *   and we can't break them.
         *
         *   To simplify things, we could use Arrays.copyOfRange(A, 1, A.length - 1) to obtain the eligible subset by
         *   excluding the bottom and top elements.  The space complexity would still be O(n), but let's play it safe
         *   for the sake of very large input arrays.
         *
         *   thus, all references to A below are adjusted to skip the first and last elements:
         *   the eligible elements for minimum pairings are A[1]..A[A.length-2]
         *
         *   we'll traverse through the eligible elements of A exactly once, but using two pointers:
         *   i increments upward, and j decrements downward from the end.
         *
         *   Let's index i and j with 0 on first of the eligible elements.. so i[0] = A[1]
         */

        WeakestChainlinkPairFinder weakestChainlinkPairFinder = new WeakestChainlinkPairFinder( requiredGapBetweenPairs ); // see comments above the MinimumPairSumFinder constructor
        int i = 0;
        int j = A.length - 3;
        do {
            if ( i <= A.length - 5 ) {
                weakestChainlinkPairFinder.visitChainlinkUpward( i, A[ i + 1 ] );
            }
            if ( j >= 2 ) {
                weakestChainlinkPairFinder.visitChainlinkDownward( j, A[ j + 1 ] );
            }
            i++;
            j--;
        } while ( i < A.length - 3 );

        return weakestChainlinkPairFinder.calculateMinimumPairSum();
    }

    /*
     * START problem-specific classes
     */

    /*
     *  class ChainlinkStrength
     *  a value object.. a simple bean for chain link strengths and the positions where they were encountered.
     */
    class ChainlinkStrength {
        private int position;
        private int strength;
        public int getPosition() {
            return position;
        }
        public void setPosition( int position ) {
            this.position = position;
        }
        public int getStrength() {
            return strength;
        }
        public void setStrength( int strength ) {
            this.strength = strength;
        }
    }


    class WeakestChainlinkPairFinder {
        private final ChainlinkStrengthCircularStack minimumsEncounteredUpward;
        private final ChainlinkStrengthCircularStack minimumsEncounteredDownward;
        private final int requiredGapBetweenPairs;

        /* ChainlinkStrengthCircularStack
         * concrete implementation of CircularLinkedStack for ChainlinkStrength value objects
         */
        class ChainlinkStrengthCircularStack extends CircularLinkedStack< ChainlinkStrength > {
            public ChainlinkStrengthCircularStack( int maxDepth ) {
                super( maxDepth );
            }
            public void push( int position, int strength ) {
                ChainlinkStrength retval = this.nextCircularValueObject();
                retval.setPosition( position );
                retval.setStrength( strength );
            }
            @Override
//        This will only be called ( max depth + 2 ) times for each stack
            public ChainlinkStrength newCircularValueObject() {
                return new ChainlinkStrength();
            }
        }

        /*
         *  in the algorithm challenge, we had to leave at least one chain link between break points,
         *  i.e. breaking the chain at two adjacent links would not produce the three desired chains
         *
         *  for grins, here we can specify an arbitrary required gap, e.g. 2 or more links in between
         *  breaks.  More depth capacity is required in the stacks, and they are adjusted accordingly.
         *  TODO Increasing much more would also increase the minimum required size of the input array A..  address
         *  this with some validation
         */
        public WeakestChainlinkPairFinder( int requiredGapBetweenPairs ) {

            this.requiredGapBetweenPairs = requiredGapBetweenPairs;
            this.minimumsEncounteredUpward = new ChainlinkStrengthCircularStack( requiredGapBetweenPairs + 2 );
            this.minimumsEncounteredDownward = new ChainlinkStrengthCircularStack( requiredGapBetweenPairs + 2 );
            // since there are two of these, not using an anonymous class.
        }


        // when the MinimumPairSumFinder (below) encounters a new minimum strength (lowest encountered so far),
        // the position and strength are pushed onto the stack.

        private void pushChainLinkToStack( int position, int strength, ChainlinkStrengthCircularStack whichStack ) {
            if ( whichStack.peek() == null || strength < whichStack.peek().getStrength() ) {
                whichStack.push( position, strength );
            }
        }
        public void visitChainlinkUpward( int position, int strength ) {
            this.pushChainLinkToStack( position, strength, this.minimumsEncounteredUpward );
        }
        public void visitChainlinkDownward( int position, int strength ) {
            this.pushChainLinkToStack( position, strength, this.minimumsEncounteredDownward );
        }
        public int calculateMinimumPairSum() {
            if ( minimumsEncounteredUpward.peek() == null || minimumsEncounteredDownward.peek() == null ) {
                throw new NullPointerException( "this shouldn't happen.. were we called before the traversals were performed?" );
            }

            int retval = minimumsEncounteredUpward.oldest().getStrength() + minimumsEncounteredDownward.oldest().getStrength(); // start with the max strength possible of all recorded links

            /*
             *   now permute over the valid combinations, recording the minimum combination, and
             *   ensuring the required gap between the elements.
             *
             *   nested loops can be spotted here, but this will not result in quadratic time complexity - this is performed
             *   on the stacks after the input array has been traversed, and there are only 9 permutations here (max)
             *   when the stack depth is 3 (i.e. for a required link gap of 1).  Increasing the gap to 2 would result
             *   in 16.  permutations = ( gap + 2 )^2.  Any reasonable gap's performance should be acceptable.
             */
            ChainlinkStrength leftMinimum = minimumsEncounteredUpward.peek();
            while ( leftMinimum != null ) {
                ChainlinkStrength rightMinimum = minimumsEncounteredDownward.peek();
                while ( rightMinimum != null ) {
                    if ( rightMinimum.getPosition() - leftMinimum.getPosition() >= 1 + this.requiredGapBetweenPairs ) {  // <-- enforce gap requirement here
                        retval = Math.min( retval, leftMinimum.getStrength() + rightMinimum.getStrength() );
                    }
                    rightMinimum = minimumsEncounteredDownward.pushedBefore( rightMinimum );
                }
                leftMinimum = minimumsEncounteredUpward.pop();
            }

            return retval;
        }

    }

    /*
     * END problem-specific classes
     */


    /*
     * START generic utility classes
     */

    /*
     *  class CircularLinkedStack
     *
     *  A fixed capacity stack.  The depth limit is specified to the constructor.
     *  A single reference is stored to the last pushed node.
     *  The PositionStrength objects are recycled from the back of the stack, their old values discarded.
     *
     *  There are pop and peek methods that do what you’d expect, but there is no push.  Concrete subclasses like ChainlinkStrengthCircularStack
     *  must implement their own push (there is no abstract method to enforce this, since the signature is unknown).
     *  The subclasses' `push` implementation should call `nextCircularValueObject()` to obtain the next available value
     *  object in the stack's cycle, which can then be populated with new values.  If the stack has not yet reached
     *  its capacity, it requests a new value object via the subclasses' implementation of the abstract
     *  `newCircularValueObject` method.  This way, the stack can limit the creation of new objects while still delegating
     *  said creation to the concrete implementation.
     *
     *  This seems suitable for simple value objects, like this case where the data is just primitives.
     */
    public abstract class CircularLinkedStack< T > {

        /*
         * class CircularLinkedNode
         * generic minecart for payload value objects
         */
        private /*static*/ class CircularLinkedNode< T > { // inner classes can't be static.. I'd likely make this a static nested class
            private T payload;
            private CircularLinkedNode< T > previous;

            public CircularLinkedNode( T payload ) {
                this.payload = payload;
            }
            public T getPayload() {
                return this.payload;
            }
            public CircularLinkedNode< T > getPrevious() {
                return this.previous;
            }
            public void setPrevious( CircularLinkedNode< T > newPrevious ) {
                this.previous = newPrevious;
            }
            public void clearPrevious() {
                this.setPrevious( null );
            }
        }

        private int maxDepth;
        private CircularLinkedNode< T > top;

        /*
         *  maxDepth is the maximum number of elements we'll keep - older ones are discarded
         */
        public CircularLinkedStack( int maxDepth ) {
            this.maxDepth = maxDepth;
        }


        public T peek() {
            if ( this.top == null )
                return null;
            return this.top.getPayload();
        }
        public T pop() {
            CircularLinkedNode< T > previouslyLast = this.top;
            if ( previouslyLast == null )
                return null;

            T payload = top.getPayload();
            this.top = top.getPrevious();
            if ( this.top != null )
                top.clearPrevious();

            return payload;
        }
        public T pushedBefore( T beforeWhich ) {
            CircularLinkedNode< T > lastNode = this.top;
            if ( lastNode == null )
                return null;

            while ( lastNode != null ) {
                if ( lastNode.getPayload() == beforeWhich && lastNode.getPrevious() != null ) {
                    // There shouldn't be any issues using identity here, as any selfsame object can only appear
                    // once in the stack.  Equality for value objects would work fine too.
                    return lastNode.getPrevious().getPayload();
                }
                lastNode = lastNode.getPrevious();
            }
            return null;
        }
        public T oldest() {
            CircularLinkedNode< T > oldestNode = this.top;
            if ( oldestNode == null )
                return null;

            while ( oldestNode.getPrevious() != null ) {
                oldestNode = oldestNode.getPrevious();
            }
            return oldestNode.getPayload();
        }

        /*
         *  obtain the value object at an arbitrary depth by traversing their links
         */
        private CircularLinkedNode< T > peekBackBy( int byHowMany ) {
            CircularLinkedNode< T > retval = this.top;
            for ( int i = 0; i < byHowMany && retval != null; i++ ) {
                retval = retval.getPrevious();
            }
            return retval;
        }


        /*
         *   nextCircularValueObject()
         *   recycle the item on the back limit (maxDepth) of the stack.
         *   if it doesn't exist (i.e. stack is under capacity), ask the
         *   client for a new one via the abstract callback method newCircularValueObject.
         *   this way, the stack controls the creation of objects.
         *
         *   this keeps instantiation of the PositionStrength objects to a maximum of (maxDepth * 2)
         *   CPU and GC are noticibly lower for arrays of 100k elements
         */
        public T nextCircularValueObject() {
            CircularLinkedNode< T > previousTop = this.top;
            CircularLinkedNode< T > soughtNode;
            CircularLinkedNode< T > oneBeforeMax = this.peekBackBy( this.maxDepth - 1 );
            if ( oneBeforeMax == null || oneBeforeMax.getPrevious() == null ) {
                soughtNode = new CircularLinkedNode<>( this.newCircularValueObject() );
            } else {
                soughtNode = oneBeforeMax.getPrevious();
                oneBeforeMax.clearPrevious();
            }
            this.top = soughtNode;
            soughtNode.setPrevious( previousTop );
            return soughtNode.getPayload();
        }
        /*
         * newCircularValueObject
         * callback to ask the client to provide a new one
         * This will only be called ( max depth + 2 ) times for each stack
         */
        public abstract T newCircularValueObject();

    }
}
