package project;

import java.io.*;

/**
 *
 * @author Sergio Silva 55457
 * @author Marco Ferreira 56886
 */
public class Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try (
            BufferedReader inReader = new BufferedReader(new FileReader(args[1]));
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));            
        )   {            
            String input;
            String[] options;
            while ((input = inReader.readLine()) != null) {
                options = input.split(" ");
                switch (options[0]) {
                    case "N": {
                        String protLine;
                        String sequence;
                        String ref;
                        try {                            
                            while ((protLine = br.readLine()) != null) {
                                ref = protLine.substring(0, 14);
                                sequence = processSequence(br);
                                if (naiveMatcher(sequence, options[1])) {
                                    out.write(ref);
                                    out.newLine();
                                }
                            }
                            br.close();
                        } catch (Exception e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                        break;
                    }
                    case "R": { // TODO : Mudar para Rabin-Karp
                        String protLine;
                        String sequence;
                        String ref;
                        try {
                            while ((protLine = br.readLine()) != null) {
                                ref = protLine.substring(0, 14);
                                sequence = processSequence(br);
                                if (naiveMatcher(sequence, options[1])) {
                                    System.out.println(ref);
                                }
                            }
                            br.close();
                        } catch (Exception e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                        break;
                    }

                    case "Q": {
                        break;
                    }

                    case "L": {
                        break;
                    }

                    default: {
                        return;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static boolean naiveMatcher(String T, String P) {
        try {
            int n = T.length();
            int m = P.length();
            for (int i = 0; i < n - m; i++) {
                if (P.compareTo(T.substring(i, i + m)) == 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return false;
    }

    private static String processSequence(BufferedReader br) {
        try {
            StringBuilder resSequence = new StringBuilder();
            String seqLine;
            while (!"".equals(seqLine = br.readLine())) {
                if (seqLine != null) {
                    resSequence.append(seqLine);
                } else {
                    return resSequence.toString();
                }
            }
            return resSequence.toString();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return "";
    }

    private static int hashR(String P) {
        return 0;
    }
}
