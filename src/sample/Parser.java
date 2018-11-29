package sample;

public class Parser {

    void pars ()
    {
        Runtime r = Runtime.getRuntime();
        Process p = null;

        try {
            p = r.exec("python parse.py");
            p.waitFor();
        }
        catch (Exception e) {
            System.out.println(e);
        }


    }
}

