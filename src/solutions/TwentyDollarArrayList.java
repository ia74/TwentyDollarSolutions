package solutions;

public class TwentyDollarArrayList {
    public int nextIndex = 0;
    int[] array;
    public TwentyDollarArrayList() {
        array = new int[100];
    }
    public int set(int index, int input) {
        int tmp = array[index];
        array[index] = input;
        return tmp;
    }
    public int get(int index) {
        return array[index];
    }
    void rebuild(int size) {
        int[] william = new int[size];
        for(int i = 0; i < nextIndex; i++) {
            william[i] = array[i];
        }
        array = william;
    }
    public void add(int input) {
        if (nextIndex > array.length - 1) rebuild(2 * array.length);
        array[nextIndex++] = input;
    }
    public void add(int index, int input) {
        if(nextIndex > array.length - 1) rebuild(2 * array.length);
        for(int i = nextIndex; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = input;
        nextIndex++;
    }
    public void remove(int index) {
        for(int i = 0; i <= nextIndex; i++) {
            if(i >= index) {
                array[i] = array[i+1];
            }
        }
        nextIndex--;
    }
    public void removeObj(int del) {
        for(int i = 0; i < nextIndex; i++) {
            if(array[i] == del) {
                remove(i);
                break;
            }
        }
    }
    public String toString() {
        String out = "[";
        for(int i = 0; i < nextIndex; i++) {
            out += array[i] + (i == nextIndex - 1 ? "" : ", ");
        }
        out += "]";
        return out;
    }
}
