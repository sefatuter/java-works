package TestPackage;

public class Constructor {
    private int x;
    private int y;

    private Constructor() {
        System.out.println("Constructor");
    }

    public Constructor(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Constructor2");
    }

    public static void main(String[] args) {
        Constructor constructor = new Constructor();
        Constructor constructor2 = new Constructor(10,20);

        bilmemne b = new bilmemne();
        b.asd();
    }
}

// Ayrı bi dosya olarak yazılmalı, package dışından ulaşılamıyor.
class bilmemne {
    public void asd(){
        System.out.println("asd");
    }
}