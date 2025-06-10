import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class teks extends Actor
{
    private GreenfootImage image;

    public teks(String imagePath, int width, int height) {
        setImageFromPath(imagePath, width, height);
    }

    public void act() {
        // Tidak ada aksi
    }

    // Mengatur gambar dari file dan mengubah ukurannya
    public void setImageFromPath(String path, int width, int height) {
        image = new GreenfootImage(path);
        image.scale(width, height); // Ubah ukuran gambar
        setImage(image);
    }

    // Fungsi untuk mengganti gambar (tanpa ubah ukuran)
    public void changeImage(String path) {
        image = new GreenfootImage(path);
        setImage(image);
    }

    // Fungsi untuk mengganti ukuran gambar yang sudah ada
    public void scaleImage(int width, int height) {
        if (image != null) {
            image.scale(width, height);
            setImage(image);
        }
    }
}
