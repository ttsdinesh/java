
import java.io.*;

public class DirectoryRename {

    public static void main(String args[]) {
        try {
            System.out.println("----------- Mission : Renaming directories and files -----------");
            System.out.println("----------- Mission control : DINESH -----------");
            new DirectoryRename().compareWithFile(null);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void compareWithFile(String strLine) {
        File folder = new File("/home/dinesht/temp");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
            } else if (listOfFiles[i].isDirectory()) {
                File oldMovieDir = listOfFiles[i];
                try {
                    System.out.println("Found movie: " + oldMovieDir.getName() + ". Rename? ");

                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        String confirmationString = br.readLine();
                        if ("yes".equalsIgnoreCase(confirmationString)
                                || "y".equalsIgnoreCase(confirmationString)
                                || "ya".equalsIgnoreCase(confirmationString)
                                || "yep".equalsIgnoreCase(confirmationString)
                                || "yup".equalsIgnoreCase(confirmationString)
                                || "roger that".equalsIgnoreCase(confirmationString)
                                || "roger tat".equalsIgnoreCase(confirmationString)) {
                            String newMoviePath = new String();
                            String[] strArray = oldMovieDir.getPath().split("/");

                            for (int j = 1; j < strArray.length - 1; j++) {
                                newMoviePath += strArray[j] + "/";
                            }
                            newMoviePath = "/" + newMoviePath;
                            File newMovieDir = new File(newMoviePath + "/" + getDirNameFromUser());
                            boolean result = oldMovieDir.renameTo(newMovieDir);
                            if (result) {
                                System.out.println(" Movie successfully renamed from " + oldMovieDir.getName() + " to " + newMovieDir.getName());
                                renameFiles(newMovieDir.getPath());
                            } else {
                                System.err.println(" Renaming " + oldMovieDir.getName() + " failed. Sorry :(");
                            }

                        } else {
                            System.out.println("Skipping renaming of " + oldMovieDir.getName() + ".");
                        }
                    } catch (Exception e) {
                    }

                } catch (Exception e) {
                }

            }
        }
    }

    private String getDirNameFromUser() {
        System.out.println("Enter movie name");
        String movieName = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            movieName = br.readLine();
        } catch (Exception e) {
        }
        String movieYear = null;
        System.out.println("Enter movie year");
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            movieYear = br.readLine();
        } catch (Exception e) {
        }
        System.out.println("Enter movie language");
        String movieLanguage = null;
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            movieLanguage = br.readLine();
        } catch (Exception e) {
        }
        return movieName + "[" + movieYear + "]" + movieLanguage;
    }

    private void renameFiles(String filePath) {
        File folder = new File(filePath);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                File newFileName = new File(filePath + "/" + constructFileName(file.getName()));
                if (file.renameTo(newFileName)) {
                    System.out.println("File " + file.getName() + " renamed to " + newFileName.getName());
                } else {
                    System.err.println("Renaming " + file.getName() + " failed. Sorry :( ");
                }
            } else {
            }
        }
    }

    private String constructFileName(String fileName) {
        String newFileName = new String();
        System.err.println("filename:" + fileName);
        int charPointer = 0;
        for (int j = 0; j < fileName.length(); j++) {
            if (Character.isLetter(fileName.charAt(j))) {
                break;
            } else {
                charPointer++;
            }
        }
        if (charPointer != 1) {
            newFileName = fileName.substring(charPointer, fileName.length());
        } else {
            newFileName = fileName;
        }

        newFileName = newFileName.replaceAll("\\s+", "_");
        return newFileName;
    }
}
