package jpg.to.png;
//By Mohammad Bagher Abiat

import java.io.File;
import java.util.Scanner;

public class JpgToPng {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter your path : ");
        String address = input.nextLine();
        if (address.endsWith("/")) {
            address = address.substring(0, address.length() - 1);
        }
        System.out.println("\n");
        File objectAddress = new File(address);

        String[] filelist = objectAddress.list();

        for (String path : filelist) {
            String newadress = address + "/" + path;
            File objectNewadress = new File(newadress);
            if (newadress.endsWith(".jpg")) {
                String rename = address + "/converted/";
                File renamef = new File(rename);
                renamef.mkdirs();
                objectNewadress.renameTo(new File(rename + path + ".png"));
                System.out.print("\u001B[32msuccessfully\n\n");
            }
        }

        File returnaddress = new File(address + "/converted");
        String[] returnaddress2 = returnaddress.list();
        System.out.print("do you wanna return the files[Y/N]");
        String re = input.nextLine().toLowerCase();
        if ("y".equals(re)) {
            for (String repath : returnaddress2) {
                if (repath.endsWith(".png")) {
                    String readd = address + "/converted/" + repath;
                    File filerepath = new File(readd);
                    String repaath = repath.substring(0, repath.length() - 4);
                    filerepath.renameTo(new File(address + "/" + repaath));
                }

            }
            System.out.print("Thanks\n\n");
        } else if ("n".equals(re)) {
            System.out.print("Thanks\n\n");

        }

    }

}
