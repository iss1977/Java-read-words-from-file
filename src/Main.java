public class Main {
    public static void main(String[] args) {

        Hangwords myWords = new Hangwords(); // create object from Hangwords


        // display random word between 4 and 10 characters
        System.out.println("Random word (4-10 chars):"+ myWords.getWord(4,10));

        // display random word having 7 characters
        System.out.println("Random word (7 chars):"+myWords.getWord(7,7));

        // display random word having minimum 10 characters
        System.out.println("Random word (min 10 chars):"+myWords.getWord(10));

        // display random word having minimum zero characters ( no restriction)
        System.out.println("Random word (no restriction):"+myWords.getWord());

        // create an array to manage by your own....
        String[] myWordList;
        myWordList = myWords.getWordsArray();
        // display the array
        System.out.println("My words (complete list of words):");
        for (String arrElem : myWordList)
            System.out.print(arrElem+" ");
        System.out.println();

    } // end main()
}
