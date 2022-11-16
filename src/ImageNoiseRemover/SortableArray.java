package noiseremoving;

/**
 * Arin Bindra
 * @param <E>
 */
public class SortableArray<E extends Comparable>{
    
    public E array[];
    
    public SortableArray()
    {
        this.array = null;
    }
    
    //--------------------------------------------------------------------------
    
    public E[] getArray()
    {
        return this.array;
    }
    
    //--------------------------------------------------------------------------
    
    public void setArray(E[] array)
    {
        this.array = null;
        this.array = array;
    }
    
    //--------------------------------------------------------------------------
    /**
     * The quick sort method first takes in the complete array as input then creates
     * partitions the array and creates smaller arrays around a pivot value in the array
     * then goes on to compare the pivot values and places them on the "left side or right side"
     * if they are smaller or larger then the value being compared using recursion
     */
    
    public void quickSort()
    {
        quickSortSegment(this.array, 0, this.array.length);
    }
    
    private void quickSortSegment(E[] array, int start, int end)
    {
        if((end - start) > 1)
        {
            int indexPartition = partition(array, start, end);
            
            quickSortSegment(array, start, indexPartition);
            
            quickSortSegment(array, indexPartition+1, end);
        }
    }
    
    private int partition(E[] array, int start, int end)
    {
        E temp;
        E partitionElement = array[start];
        int leftIndex = start;
        int rightIndex = end-1;
        
        while(leftIndex < rightIndex)
        {
            while((array[leftIndex].compareTo(partitionElement) <= 0) && (leftIndex < rightIndex))
            {
                leftIndex++;
            }
            
            while(array[rightIndex].compareTo(partitionElement) > 0)
            {
                rightIndex--;
            }
            
            if(leftIndex < rightIndex)
            {
                temp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = temp;
            }
        }
        
        array[start] = array[rightIndex];
        array[rightIndex] = partitionElement;
        
        return rightIndex;
    }
}
