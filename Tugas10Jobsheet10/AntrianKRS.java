package Tugas10Jobsheet10;
public class AntrianKRS {
    Mahasiswa[] data;
    int front, rear, size, max, sudahKRS;

    public AntrianKRS() {
        max = 10;
        data = new Mahasiswa[max];
        front = size = sudahKRS = 0;
        rear = -1;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == max;
    }
    
    public void clear() {
        front = rear = -1;
        size = 0;
        System.out.println("Antrian berhasil dikosongkan");
    }
    
    public void enqueue(Mahasiswa mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh!");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            if (rear == max - 1) {
                rear = 0;
            } else {
                rear++;
            }
        }
        data[rear] = mhs;
        size++;
    }
    
    public void prosesKRS() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }
        if (sudahKRS >= 30) { 
            System.out.println("Kuota DPA sudah penuh!");
            return;
        }
        for (int i = 0; i < 2 && !isEmpty(); i++) {
            Mahasiswa mhs = data[front];
            System.out.println("Proses KRS: " + mhs.nama);
            sudahKRS++;
            size--;
            if (isEmpty()) {
                front = rear = -1;
            } else {
                if (front == max - 1) {
                    front = 0;
                } else {
                    front++;
                }
            }
        }
    }
    
    public void printAll() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }
        int i = front;
        while (i != rear) {
            System.out.println(data[i].nama);
            i = (i + 1) % max;
        }
        System.out.println(data[i].nama);
    }
    
    public void printFirst2() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }
        System.out.println("2 Antrian Terdepan:");
        for (int i = 0; i < 2 && i < size; i++) {
            System.out.println(data[(front + i) % max].nama);
        }
    }
    
    public void printLast() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }
        System.out.println("Antrian Terakhir: " + data[rear].nama);
    }
    
    public void printInfo() {
        System.out.println("Jumlah antrian: " + size);
        System.out.println("Jumlah sudah proses KRS: " + sudahKRS);
        System.out.println("Jumlah belum proses KRS: " + (30 - sudahKRS));
    }
}