package tree;

import Excepciones.EmptyException;
import lista.Nodo;

import java.util.ArrayList;
import java.util.List;

public class Btree<T extends Comparable<T>> implements Tree<T>{
    private Nodo<T> root;

    public Btree(){
        this((T)null);
    }

    public Btree(T element) {
        this.root = new Nodo<>(element);
    }

    @Override
    public boolean add(T element) {
        if (this.root == null){
            this.root = new Nodo<>();
        }
        if(element!=null){
            if(root.getValue()==null){
                root.setValue(element);
            }else{
                add(root,element);
            }
            return true;
        }
        return false;
    }

    private void add(Nodo<T> root, T element) {
        if(root.getValue().compareTo(element) <= -1){
            if(root.getRight()==null){
                Nodo<T> temp = new Nodo<>(element);
                temp.setLevel(root.getLevel()+1);
                root.setRight(temp);
            }else{
                add(root.getRight(),element);
            }
        }else{
            if(root.getLeft()==null){
                Nodo<T> temp = new Nodo<>(element);
                temp.setLevel(root.getLevel()+1);
                root.setLeft(temp);
            }else{
                add(root.getLeft(),element);
            }
        }
    }


    @Override
    public boolean remove(T element) {
        try{
            isEmpty();
            this.root = remove(this.root,element);
            return true;
        } catch (EmptyException e) {
            System.out.println(e.getMessage()+"\n");
        }
        return false;
    }


    private Nodo<T> remove(Nodo<T> root, T element) {
        Nodo<T> tmp;
        //caso base
        if (root == null){
            return root;
        }

        if (root.getValue().compareTo(element) > 0){ //mayor que la raiz
            tmp = remove(root.getLeft(), element);
            root.setLeft(tmp);
        } else if (root.getValue().compareTo(element) < 0) { //menor que la raiz
            tmp = remove(root.getRight(), element);
            root.setRight(tmp);
        } else {
            //lo encontre
            //es la raiz
            //la raiz tiene nodo izq?
            if (root.getLeft() == null){
                return root.getRight();
            }
            //la raiz tiene nodo der?
            if (root.getRight() == null){
                return root.getLeft();
            }
            //tengo los dos hijos
            //busco al hijo pequeño
            Nodo<T> smallest = sons(root);
            root.setValue(smallest.getValue());
            tmp = remove(root.getRight(), smallest.getValue());
            root.setRight(tmp);
        }
        return root;
    }


    private Nodo<T> sons(Nodo<T> current) {
        current = current.getRight();
        while (current != null && current.getLeft() != null){
            current = current.getLeft();
        }
        return current;
    }


    private Nodo<T> search(Nodo<T> root, boolean menor) {
        if(menor){
            if(root.getLeft() == null) return root;
            else return search(root.getLeft(),menor);
        }else{
            if(root.getRight() == null) return root;
            else return search(root.getRight(),menor);
        }
    }


    @Override
    public void inorder() {
        try {
            isEmpty();
            inorder(root);
        } catch (EmptyException e) {
            System.out.println(e.getMessage()+"\n");
        }

    }

    private void inorder(Nodo<T> root) { //imprime primero la izquierda, luego la raiz y por ultimo la derecha
        if(root != null){
            inorder(root.getLeft());
            System.out.println(root.getValue()+" ");
            inorder(root.getRight());
        }
    }


    @Override
    public void postorder() { //imprime primero la derecha, luego la izquierda y por ultimo la raiz
        try {
            isEmpty();
            postorder(root);
        } catch (EmptyException e) {
            System.out.println(e.getMessage()+"\n");
        }
    }

    private void postorder(Nodo<T> root) {
        if(root != null){
            postorder(root.getRight());
            postorder(root.getLeft());
            System.out.println(root.getValue()+" ");
        }
    }


    @Override
    public void preorder() { //imprime primero la raiz, luego la izquierda y por ultimo la derecha
        try {
            isEmpty();
            preorder(root);
        } catch (EmptyException e) {
            System.out.println(e.getMessage()+"\n");
        }
    }

    private void preorder(Nodo<T> root) {
        if(root != null){
            System.out.println(root.getValue()+" ");
            preorder(root.getRight());
            preorder(root.getLeft());
        }
    }


    @Override
    public void ampSearch() {
        try {
            isEmpty();
            int h = height(root);
            for (int i = 1; i <= h; i++) {
                ampSearch(root,i);
            }
        } catch (EmptyException e) {
            System.out.println(e.getMessage()+"\n");
        }
    }

    private void ampSearch(Nodo<T> root, int i) {
        if(root == null){
            return;
        }
        if(i == 1){
            System.out.println(root.getValue()+" ");
        }else if(i > 1){
            ampSearch(root.getLeft(),i-1);
            ampSearch(root.getRight(),i-1);
        }
    }


    @Override
    public void deepSearch(T element) {
        try {
            isEmpty();
            deepSearch(root,element);
        } catch (EmptyException e) {
            System.out.println(e.getMessage()+"\n");
        }
    }

    private void deepSearch(Nodo<T> root, T element) {
        if(root != null){
            if(root.getValue().equals(element)){
                System.out.println("Elemento encontrado: "+element);
            }else{
                deepSearch(root.getRight(),element);
                deepSearch(root.getLeft(),element);
            }
        }
    }


    @Override
    public int height() {
        try {
            isEmpty();
            return height(root);
        } catch (EmptyException e) {
            System.out.println(e.getMessage()+"\n");
        }
        return 0;
    }

    private int height(Nodo<T> root) {
        if(root == null){
            return 0;
        }else{
            int left = height(root.getLeft());
            int right = height(root.getRight());
            if(left > right){
                return left+1;
            }else{
                return right+1;
            }
        }
    }


    @Override
    public void level() {
        level(root, 0);
    }

    private void level(Nodo<T> root, int i) {
        if(root != null){
            root.setLevel(i);
            level(root.getLeft(),i+1);
            level(root.getRight(),i+1);
        }
    }


    @Override
    public boolean isEmpty() throws EmptyException {
        if(root == null || root.getValue() == null)
            throw new EmptyException("El arbol esta vacio.");
        return false;
    }


    @Override
    public Nodo<T> search(T element) throws EmptyException {
        return null;
    }


    @Override
    public boolean isThere(T element) throws EmptyException {
        return false;
    }


    public Btree<T> distinct(Btree<T> A, Btree<T> B) {
        Btree<T> C = new Btree<>();
        try {
            A.isEmpty();
            B.isEmpty();
            distinct(A.root, B, C);
        } catch (EmptyException e) {
            System.out.println(e.getMessage());
        }
        return C;
    }

    private void distinct(Nodo<T> element, Btree<T> B, Btree<T> C) {
        if (element != null) {
            distinct(element.getLeft(), B, C);
            try {
                if (!B.isThere(element.getValue())) {
                    C.add(element.getValue());
                }
            } catch (EmptyException e) {
                System.out.println(e.getMessage());
            }
            distinct(element.getRight(), B, C);
        }
    }


    public void treePrinter(){
        try {
            isEmpty();
            TreePrinter printer = new TreePrinter();
            List<String> idnt = new ArrayList<>();
            printer.printFullTree(root,"-", idnt,false);
        } catch (EmptyException e) {
            System.out.println(e.getMessage()+"\n");
        }
        System.out.println();
    }
}