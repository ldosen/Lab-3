
## Questions regarding using a LinkedList over an ArrayList. Does anything change?
In short, no. The tests pass just as they did when the operations were performed using an ArrayList. Because both of these classes extend the List class, they have to implement the same methods laid out in the List interface. Knowing that, it makes sense why the tests pass no matter what type of List is used.

## What happens if you use `list.remove(Integer.valueOf(77))?`
When you try to remove all instances of 77 from the List using the List method instead of the Iterator method, an error is thrown. This is because the `List` instantiates the `Iterator` object, which can then iterate over the list using its methods. Additionally, `List.remove()` has to walk down the list each time while the Iterator stays on each object until told to move again. `List` does not understand what `next()` means and therefore throws an error.

## Which of the two lists performs better as the size increases?
As size increases, the LinkedList performs better than the ArrayList when insertions and deletions are concerned. This is because the LinkedList performs insertions and deletions in constant time rather than linear time. However, LinkedLists perform much worse at accessing when size increases. I've included the raw time complexities of each test below to see the comparison. 

## Test Results

SIZE = 10
REPS = 1000000

testArrayListAccess = 16ms
testLinkedListAddRemove = 38ms
testLinkedListAccess = 17ms
testArrayListAddRemove = 73ms

SIZE = 100
REPS = 1000000

testArrayListAccess = 17ms
testLinkedListAddRemove = 36ms
testLinkedListAccess = 29ms
testArrayListAddRemove = 86ms

SIZE = 1000
REPS = 1000000

testArrayListAccess = 18ms
testLinkedListAddRemove = 36ms
testLinkedListAccess = 364ms
testArrayListAddRemove = 265ms

SIZE = 10000
REPS = 1000000

testArrayListAccess = 20ms
testLinkedListAddRemove = 39ms
testLinkedListAccess = 5s227ms
testArrayListAddRemove = 1s856ms

SIZE = 100000
REPS = 1000000

testArrayListAccess = 37ms
testLinkedListAddRemove = 64ms
testLinkedListAccess = 1m24s551ms
testArrayListAddRemove = 36s145ms
