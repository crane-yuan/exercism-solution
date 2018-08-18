class RnaTranscription {

    String transcribe(String dnaStrand) {
        char[] array = dnaStrand.toCharArray();

        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case 'G':
                    array[i] = 'C';
                    break;
                case 'C':
                    array[i] = 'G';
                    break;
                case 'T':
                    array[i] = 'A';
                    break;
                case 'A':
                    array[i] = 'U';
                    break;
            }
        }
        return String.valueOf(array);
    }

}
