import java.util.HashMap;
import java.util.Map;

public class MainTest {
    public static String parameters = "; what = Java;;; file =data.log;size=1;";
    private static Map<String, String> params;


    public static void main(String[] args) {

        params = getMapParams(parameters);
        System.out.println("done");

    }

    public static Map<String, String> getMapParams(String parameters) {
        Map<String, String> result = new HashMap<String, String>();
        parameters = parameters.replaceAll(" ", "");
        int startPos = 0;
        int endChar = ';';
        int currPos;

        do {
            currPos = parameters.indexOf(endChar, startPos);
            if (currPos != -1) {
                String pair = parameters.substring(startPos, currPos);
                startPos = currPos + 1;
                int separPos = pair.indexOf('=');
                if(separPos!=-1) {
                    String paramName = pair.substring(0, separPos);
                    String paramValue = pair.substring(separPos + 1);
                    System.out.println(paramName + " = " + paramValue);
                    result.put(paramName, paramValue);
                }
            }
        } while (currPos != -1);

        return result;
    }




}
