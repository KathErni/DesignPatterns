package Creational.Prototype;

public class DIY {
    public static void main(String[] args) {
        var menu = new Menu();
        menu.copy(new Save());
    }
}

interface File{
    void add();
    File clone();
}

class Save implements File{
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void add() {
        System.out.println("File saved!");
    }
    public File clone(){
        Save newLoad = new Save();
        newLoad.setFileName(fileName);
        return newLoad;
    }
    
}

class Menu{

    public void copy(File file){
        File newFile = file.clone();
        System.out.println("Original Save File: ");
        file.add();
        System.out.println("Copied Save File: ");
        newFile.add();

    }
}