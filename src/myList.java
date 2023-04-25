import java.util.Arrays;

public class myList <T> {
    private T[] genericArray;
    private int Capacity;
    int size = 0;


    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public T[] getGenericArray() {
        return genericArray;
    }

    public void setGenericArray(T[] genericArray) {
        this.genericArray = genericArray;
    }

    public myList() {
        setCapacity(10);
        setGenericArray((T[]) new Object[getCapacity()]);
    }

    public myList(int capacity) {
        setCapacity(capacity);
        setGenericArray((T[]) new Object[capacity]);
    }

    //How many elements are there in array
    public int size() {
        int counter = 0;
        for (int i = 0; i < getCapacity(); i++) {
            if (getGenericArray()[i] != null) {
                counter++;
            }
        }
        return counter;

    }

    public void add(T data) {
        if (getCapacity() == size()) {
            // If there is not enough space in the array, double the size.
            int newCapacity = genericArray.length * 2;
            genericArray = Arrays.copyOf(genericArray, newCapacity);
        }

        // Add data to the end of the array and increase the size.
        genericArray[size] = data;
        size++;


    }

    public void printList() {
        for (T t : genericArray) {
            System.out.print(t + ",");

        }
        System.out.println();
    }

    public Object get(int index) {
        if (index >= this.genericArray.length || index < 0)
            return null;
        return this.genericArray[index];
    }

    public boolean remove(int index) {
        if (index < 0) {
            System.out.println("HATA: Negatif index değeri geçersizdir.");
            return false;
        }

        if (getGenericArray() == null) {
            System.out.println("HATA: Dizi boş.");
            return false;
        }

        if (index >= getCapacity()) {
            System.out.println("HATA: Index değeri dizinin sınırları dışında.");
            return false;
        }
        if (getGenericArray()[index] == null) {
            System.out.println("HATA: Kaldırmaya çalıştığınız index'teki değer null.");
            return false;
        }


        for (int i = index; i < getCapacity() - 1; i++) {
            getGenericArray()[i] = getGenericArray()[i + 1];
        }

        getGenericArray()[getCapacity() - 1] = null;
        return true;
    }

    public void set(int index, T element) {
        //If index not empty
        if (getGenericArray()[index] != null) {
            //set
            getGenericArray()[index] = element;

        }
    }

    public String toString() {
        if (getGenericArray() == null || getCapacity() == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < getCapacity() - 1; i++) {
            sb.append(getGenericArray()[i]).append(", ");
        }
        sb.append(getGenericArray()[getCapacity() - 1]).append("]");
        return sb.toString();
    }

    public int indexOf(T element){
        int index = -1;
        for(T i : getGenericArray()){
            index++;
            if(i == element){
                return index;
            }
        }
        return -1;
    }

    public int lastIndexOf(T element){
        int index = -1;
        int lastIndex = -1;
        for(T i : getGenericArray()){
            index++;
            if(i == element){
                lastIndex = index;
            }
        }
        return lastIndex;
    }
  public boolean isEmpty(){
        boolean  isEmpty = true;
        for( T element : getGenericArray()){
            if (element != null){
                isEmpty = false;
                break;

            }

        }return false;
  }
    public T[] toArray(){
        T[] newArray = (T[]) new Object[size()];
        for(int i = 0; i < size(); i++){
            newArray[i] = getGenericArray()[i];
        }
        return newArray;
    }
    public void clear(){
        for(int i = 0; i < size(); i++){
            getGenericArray()[i] = null;
        }
    }
    public myList<T> subList(int start, int finish){

        if(start>=0 && finish>=0){
            if(start<=this.getCapacity() && finish<=this.getCapacity()){
                int size = finish - start + 1;

                myList<T> myList = new myList<>(size);
                for(int i = start; i <= finish; i++){
                    myList.add((T) get(i));
                }
                return myList;
            }

        }return null;

    }
    public boolean contains(T data){
        boolean isContains = false;
        for (int i = 0; i < size(); i++){
            if(getGenericArray()[i] != null && getGenericArray()[i].equals(data)){
                isContains = true;
            }
        }
        return isContains;
    }

}
























