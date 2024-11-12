public class Yazilimci extends Employee implements Maaslar {
    public Yazilimci(String maas, String first, String last, String ssn) {
        super(first, last, ssn);

        System.out.println(maas);
        // TODO Auto-generated constructor stub
    }

    public Yazilimci(String first, String last, String ssn) {
        super(first, last, ssn);
        // TODO Auto-generated constructor stub
    }

    void test() {
        lastName = "20";
        System.out.println(
                super.getFirstName()

        );
        setFirstName("Onur");
    }

    @Override
    public double maasHesapla() {
        // TODO Auto-generated method stub
        return 500 * 30;
    }

}