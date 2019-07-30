import net.sourceforge.tess4j.Tesseract;

import java.io.File;

public class OcrReader {

    /*
    *  You would need to follow the instructions of what files needed for Arabic in:
    *  https://github.com/tesseract-ocr/tesseract/wiki/Data-Files#cube-data-files-for-version-304305
    *
    *  Arabic additional files:
    *  ara.cube.bigrams, ara.cube.fold, ara.cube.lm, ara.cube.nn, ara.cube.params,
    *  ara.cube.word-freq, ara.cube.size, ara.tesseract_cube.nn
    *
    * */
    public static void main(String[] args) throws Exception{
        String basePath = "C:/temp/Tesseract/";
        String inputEnglishFilepath = basePath + "testocr.png"; //  file english_doc.tif has an issue with TIFFImageReader
        String inputArabicFilepath = basePath + "arabic_text.png"; // also try: arabic_text2.png

        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath(basePath);

        final File file = new File(inputEnglishFilepath);
        String fulltext = tesseract.doOCR(file);

        System.out.println("-------------- output -------------");
        System.out.println(fulltext);
        System.out.println("---------------- End --------------");

        tesseract.setLanguage("ara");
        final File file2 = new File(inputArabicFilepath);
        fulltext = tesseract.doOCR(file2);

        System.out.println("-------------- output -------------");
        System.out.println(fulltext);
        System.out.println("---------------- End --------------");

    }
}
