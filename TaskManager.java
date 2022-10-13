import java.util.ArrayList;
import java.util.Objects;

public class TaskManager {
    static boolean ukr = true;
    static ArrayList<String> dataSentence = new ArrayList<>();
    static ArrayList<ArrayList<String>> dataSentenceOfWords = new ArrayList<>();
    static ArrayList<ArrayList<String>> SNPall = new ArrayList<>();
    static ArrayList<Integer> numOfSentences = new ArrayList<>();

    void switchFile() {
        ukr = !ukr;

        if (!ukr) {
            System.out.println("English file");
        } else {
            System.out.println("Ukrainian file");
        }

        dataSentence = new ArrayList<>();
        dataSentenceOfWords = new ArrayList<>();
        SNPall = new ArrayList<>();
        numOfSentences = new ArrayList<>();
    }

    public static void firstTask() {
        String data = ukr ? FileHelper.readFile("files/fileukr.txt") : FileHelper.readFile("files/fileeng.txt");
        DisplayHelper.displayData(data);

        int index1 = 0;
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '.' || data.charAt(i) == '?') {
                dataSentence.add(data.substring(index1, i + 1));
                index1 = i + 1;
            }
        }

        for (String i : dataSentence) {
            ArrayList<String> words = new ArrayList<>();
            String sentence = i.trim();

            int index2 = 0;
            for (int j = 0; j < sentence.length(); j++) {
                if (sentence.charAt(j) == ' ' || sentence.charAt(j) == '"' ||
                        j == sentence.length() - 1) {
                    words.add((sentence.substring(index2, j).trim()));

                    index2 = j + 1;
                }
            }
            dataSentenceOfWords.add(words);
        }

        for (ArrayList<String> mas : dataSentenceOfWords) {
            ArrayList<String> test = new ArrayList<>();
            ArrayList<String> SNP1 = new ArrayList<>();

            int count = 0;
            for (String word : mas) {
                String word2 = word.toLowerCase();

                if (!word.equals(word2) && word.length() > 3) {
                    test.add(word);

                    count++;
                } else count = 0;

                if (count >= 3) {
                    String SNP = "";

                    for (int i = test.size() - 3; i < test.size(); i++) {
                        if (test.get(i).indexOf(",") > 0 && i < test.size()-1) {
                            break;
                        }
                        SNP += " " + test.get(i);
                    }
                    SNP1.add(SNP);
                }
            }
            SNPall.add(SNP1);
        }
        DisplayHelper.showThreeWords(SNPall);
        InputHelper.waitBeforeMenu();
    }

    public static void secondTask() {
        ArrayList<String> Sentences = new ArrayList<>();

        int index = 0;
        for (ArrayList<String> mas : SNPall) {
            if (!mas.isEmpty()) {
                numOfSentences.add(index);
            }
            index++;
        }

        for (int i : numOfSentences) {
            if (i == 0) {
                Sentences.add(dataSentence.get(i + 1));
            } else if (i == dataSentence.size() - 1) {
                Sentences.add(dataSentence.get(i - 1));
            } else {
                Sentences.add(dataSentence.get(i - 1));
                Sentences.add(dataSentence.get(i + 1));
            }
        }

        DisplayHelper.showRightSentences(Sentences);
        InputHelper.waitBeforeMenu();
    }

    public static void thirdTask() {
        int max = 0;
        ArrayList<String> replaced = new ArrayList<>();

        for (ArrayList<String> words:dataSentenceOfWords) {
            int count = 0;
            for (String i: words) {
                if (!Objects.equals(i, "")){
                    count++;
                }
            }
            if (max < count) {
                max = count;
            }
        }

        int index = 0;
        for (String data: dataSentence) {
            if (SNPall.get(index).isEmpty()) {
                replaced.add(data);
            } else {
                for (String i: SNPall.get(index)) {
                    replaced.add(dataSentence.get(index).replace(i, (" " + String.valueOf(max))));
                }
            }
            index++;
        }

        String data = "";
        for (String i: replaced) {
            data += i;
        }

        DisplayHelper.displayData(data);
        FileHelper.createAndWriteFile("files/filename.txt", data);
        InputHelper.waitBeforeMenu();
    }
}
