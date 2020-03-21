package manu.java.cert;


import java.util.*;


public class DocumentStore {
    private Collection<String> documents = new ArrayList<String>();
    private int capacity;
    private final String a="a";
    private Collection<String> documents2 = new ArrayList<String>();

    public DocumentStore(int cap) {
        capacity = cap;
    }

    public int getCapacity() { 
      return capacity;
    }

    public Collection<String> getDocuments() {
      return documents; 
    }

    public void addDocument(String document) {
        if (this.documents.size() >= capacity) {

            throw new IllegalStateException();
        }

        else {
        	final String str = document;
        	documents.add(str);
        }
    }
    
    @Override 
    public String toString() {
        return String.format("Document store: %d/%d", documents.size(), capacity);
    }
    
    public static void main(String[] args) {
        DocumentStore documentStore = new DocumentStore(2);
        documentStore.addDocument("item");
        documentStore.addDocument("item");
//        documentStore.addDocument("item");
        System.out.println(documentStore);
    }
}