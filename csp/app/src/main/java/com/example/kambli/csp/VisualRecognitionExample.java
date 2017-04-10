package com.example.kambli.csp;



import java.io.File;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassifier;

public class VisualRecognitionExample {

  public static void main(String[] args) {
    VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
    service.setApiKey("df890fb24684bf40b162895476f4d185707e9df3");

    System.out.println("Classify an image");
    ClassifyImagesOptions options =
        new ClassifyImagesOptions.Builder().images(new File("C:/Users/KAMBLI/AndroidStudioProjects/csp/app/src/main/java/com/example/kambli/csp/car.jpg")).build();
    VisualClassification result = service.classify(options).execute();
    System.out.println(result);


    /*System.out.println("Create a classifier with positive and negative images");
    ClassifierOptions createOptions = new ClassifierOptions.Builder().classifierName("foo")
        .addClass("car", new File("src/test/resources/visual_recognition/car_positive.zip"))
        .addClass("baseball", new File("src/test/resources/visual_recognition/baseball_positive.zip"))
        .negativeExamples(new File("src/test/resources/visual_recognition/negative.zip")).build();
    VisualClassifier foo = service.createClassifier(createOptions).execute();
    System.out.println(foo);

    System.out.println("Classify using the 'Car' classifier");
    options = new ClassifyImagesOptions.Builder().images(new File("src/test/resources/visual_recognition/car.png"))
        .classifierIds("car").build();
    result = service.classify(options).execute();
    System.out.println(result);

    System.out.println("Update a classifier with more positive images");
    ClassifierOptions updateOptions = new ClassifierOptions.Builder()
        .addClass("car", new File("src/test/resources/visual_recognition/car_positive.zip")).build();
    VisualClassifier updatedFoo = service.updateClassifier(foo.getId(), updateOptions).execute();
    System.out.println(updatedFoo);
*/
  }
}