import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        /* ImageProcessor returns 4-dimensional float array -> float[?][224][224][3]
         * First dimension of the array is a batch for neural network,
         * You may pass multiple image paths to ImageProcessor
         * */
        ImageProcessor imageProcessor = new ImageProcessor();
        Classificator classificator = new Classificator();
        float[][][][] imageData = imageProcessor.loadAndNormalizeImages("images/block.jpg","images/block1.jpg","images/block2.jpg");
        List<String> result = classificator.classify(imageData);
        for(String label: result) {
            if(label.contains("switch")||label.contains("mailbox")){
                System.out.println("Object detected");
            }
        }
    }
}
