/**
 * Gets the path for the current directory
 * 
 * @author Alejandro Rodríguez
 */

public class DirectoryPath {
    private final String CLASSNAME; //this class name
    private String currentPath;     //path for current directory, if not running within a .jar file
	
    public DirectoryPath() {
        CLASSNAME = "DirectoryPath.class";
        currentPath = null;
        setCurrentPath();
    }
	
    /**
     * Discovers absolute path
     */
    private void setCurrentPath() {
        currentPath = this.getClass().getClassLoader().getResource(CLASSNAME).getPath();    //this class locatio
        currentPath = currentPath.substring(currentPath.indexOf("/"));                      //removes preceiding "file:"
        currentPath = currentPath.replaceAll("%20", " ");                                   //removes blank space encoding
		
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {              //removes preceiding "/"
            currentPath = currentPath.substring(1);
        }
        
        if(currentPath.contains(".jar!/" + CLASSNAME)) {
            //System.out.println(currentPath);                                              //console debug
            currentPath = currentPath.substring(0, currentPath.lastIndexOf("/"));           //removes class name
        }
		
        currentPath = currentPath.substring(0, currentPath.lastIndexOf("/") + 1);           //removes class name or .jar name
    }
	
    /**
     * @return The current directory
     */
    public String getPath() {
        return currentPath;
    }
}
