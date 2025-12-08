import java.util.ArrayList;
import java.util.List;

/**
 * Represents a directory in the file system tree.
 * A directory can contain other directories and files as children.
 */
public class FolderNode extends FileSystemNode {

    private List<FileSystemNode> children;

    public FolderNode(String name, FolderNode parent) {
        super(name, parent);
        this.children = new ArrayList<>();
    }


    @Override
    public boolean isFolder() {
        if (this instanceof FolderNode == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a list view of the children contained directly inside this directory.
     * Modifying the returned list is not required to be supported.
     */
    public List<FileSystemNode> getChildren() {
        // TODO: return the list of child nodes (possibly a defensive copy)
        List<FileSystemNode> stepChildren = new ArrayList<FileSystemNode>();
        for (FileSystemNode fileNode : children) {
            stepChildren.add(fileNode);
        }
        return stepChildren;
    }

    /**
     * Searches the children of this directory for a node whose name matches the input.
     * Only direct children are considered, not deeper descendants.
     */
    public FileSystemNode getChildByName(String childName) {
        // TODO: scan children for a matching name and return the node if found
        for (FileSystemNode fileSystemNode : children) {
            if (fileSystemNode.getName().equals(childName)) {
                return fileSystemNode;
            }
        }
        return null;
    }

    /**
     * Creates a new file directly inside this directory with the given name and size.
     * If a child with the same name already exists, no file is created and false is returned.
     * Otherwise the new file is added and true is returned.
     */
    public boolean addFile(String fileName, int size) {
        // TODO: implement uniqueness check and insertion of a new FileNode
        if (getChildByName(fileName) != null) {
            return false;
        }

        children.add(new FileNode(fileName, getParent(), size));
        return true;
    }

    /**
     * Creates a new subdirectory directly inside this directory with the given name.
     * If a child with the same name already exists, no folder is created and false is returned.
     * Otherwise the new folder is added and true is returned.
     */
    public boolean addFolder(String folderName) {
        // TODO: implement uniqueness check and insertion of a new FolderNode
        if (getChildByName(folderName) != null) {
            return false;
        }

        children.add(new FolderNode(folderName, getParent()));
        return true;
    }

    /**
     * Searches this directory and all of its descendants for nodes whose name matches the input.
     * When a match is found, its full path can be printed by the caller using toString().
     */
    public boolean containsNameRecursive(String searchName) {
        // TODO: check this directory and all descendants for the given name
        
        if (this.getName().equals(searchName)) {
            this.toString();
            return true;
        }

        for (FileSystemNode child : children) {
            if (child.isFolder() == true) {
                FolderNode childFolder = (FolderNode) child;
                childFolder.containsNameRecursive(searchName);
            } else {
                if (child.getName().equals(searchName)) {
                    child.toString();
                    return true;
                }
            }
        }

        return false;

    }

    @Override
    public int getHeight() {
        // TODO: compute the maximum height among children; empty folders have value 0
        List<FileSystemNode> myLilChildren = this.getChildren();
        int greatestHeight = 0;


        if (myLilChildren.size() == 0 || !this.isFolder()) {
            return 0;
        } else if (this.isFolder() == true) {
            for (int i = 0; i < myLilChildren.size(); i++) {
                int thisChildsHeight = myLilChildren.get(i).getHeight();
                if (thisChildsHeight > greatestHeight) {
                    greatestHeight = thisChildsHeight;
                }
            }
        }
        
        return greatestHeight + 1;

    }

    @Override
    public int getSize() {
        // TODO: sum the sizes of all files contained in this directory and its descendants
        
        List<FileSystemNode> myLilChildren = this.getChildren();
        int size = 0;

        if (!this.isFolder()) {
            return this.getSize();
        } else if (myLilChildren.size() == 0){
            return 0;
        }
        
        else if (this.isFolder() == true) {
            for (int i = 0; i < myLilChildren.size(); i++) {
                size += myLilChildren.get(i).getSize();
            }
        }
        
        return size;
        
    }

    @Override
    public int getTotalNodeCount() {
        // TODO: count this directory plus all descendant files and folders
        

        List<FileSystemNode> myLilChildren = this.getChildren();
        int size = 0;

        if (myLilChildren.size() == 0 || !this.isFolder()) {
            return 1;
        } else if (this.isFolder() == true) {
            for (int i = 0; i < myLilChildren.size(); i++) {
                size += myLilChildren.get(i).getTotalNodeCount();
            }
        }
        
        return size + 1;
    }


}

