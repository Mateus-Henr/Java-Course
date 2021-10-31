package challenge.mine.second;

public class Main
{
    public static void main(String[] args)
    {
        HardDisk hd = new HardDisk();
        MyString myString = new MyString("My First String");
        Gallery myGallery = new Gallery("Picture of me Walking");
        Gallery myGallery2 = new Gallery("Picture of me Walking2");


        hd.save(myString);
        hd.save(myGallery);
        hd.save(myGallery2);
        hd.getAllInternalStorage();
    }
}
