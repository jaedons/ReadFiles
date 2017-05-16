import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadFiles {  
  
    public static void main(String[] args) throws Exception {  
        File file = new File("E:\\工作\\福建华网\\20170516\\201612_各县乡镇数据B\\201612_各县乡镇数据");  
        List<String> filelist = new ArrayList<String>();  
        List<String> list = getAllFiles(file, filelist );  
        for(String path:list){
        	System.out.println(path);
        }
    }  
  
    static List<String> getAllFiles(File dir, List<String> filelist){  
        File[] fs = dir.listFiles();  
        for (int i = 0; i < fs.length; i++) {  
            //匹配log结尾的文件  
        	String path = fs[i].getAbsolutePath();
            if (path.matches(".*\\.xls")||path.matches(".*\\.xlsx")) {   
                filelist.add(path);  
            }  
            //若为文件夹，就调用getAllFiles方法  
            if (fs[i].isDirectory()) {  
                try {  
                    getAllFiles(fs[i], filelist);  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        return filelist;  
    }  
}  