/**
 * MSInterviewSolutionIII
 *
 * @author black
 * @date 2019-07-25
 */
public class MSInterviewSolutionIII {

    public static void main(String[] args) {
        RingBuffer buffer = new RingBuffer(8);
        buffer.addItem(1);
        buffer.addItem(2);
        buffer.addItem(3);
        buffer.addItem(4);

        System.out.println(buffer.getItem());
        buffer.deleteItem();
        buffer.deleteItem();
        buffer.deleteItem();
        buffer.deleteItem();
        buffer.deleteItem();
        buffer.deleteItem();
        buffer.deleteItem();
        System.out.println(buffer.getAllItems().length);
        buffer.addItem(1);
        buffer.addItem(2);
        buffer.addItem(3);
        System.out.println(buffer.getItem());
        buffer.addItem(4);
        buffer.addItem(5);
        buffer.addItem(6);
        buffer.addItem(7);
        buffer.addItem(8);
        buffer.addItem(9);
        System.out.println(buffer.getItem());
    }

    public static class RingBuffer {

        private int currentIndex;
        private int oldIndex;
        private int[] items;
        private int currentSize;

        public RingBuffer(int size) {
            if (size <= 0) {
                throw new IllegalArgumentException();
            }
            currentIndex = -1;
            oldIndex = -1;
            items = new int[size];
            currentSize = 0;
        }

        public void addItem(int item) {
            currentIndex++;
            currentIndex = currentIndex % items.length;
            items[currentIndex] = item;
            if (oldIndex < 0) {
                oldIndex++;
            } else if (currentSize == items.length) {
                oldIndex++;
                oldIndex = oldIndex % items.length;
            }
            currentSize++;
            currentSize = Math.min(currentSize, items.length);
        }

        public int getItem() {
            if (currentSize == 0) {
                return 0;
            }
            return items[oldIndex];
        }

        public int[] getAllItems() {
            int[] result = new int[currentSize];
            for (int i = 0; i < currentSize; i++) {
                int index = (oldIndex + i) % items.length;
                result[i] = items[index];
            }
            return result;
        }

        public void deleteItem() {
            if (currentSize == 0) {
                return;
            }
            currentSize--;
            items[oldIndex] = 0;
            oldIndex++;
            oldIndex = oldIndex % items.length;
        }
    }
}
