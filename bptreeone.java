import java.util.Scanner;

class bptreeone{
    Scanner input= new Scanner(System.in);
    public class bpnode{
        int[] data;
        int i;
        bpnode[] childpointer;
        bpnode[] parentpointer;
        bpnode[] next;
        bpnode(int order){
            this.i=0;
            this.data= new int[order];
            this.childpointer=new bpnode[order+2];
            this.parentpointer=new bpnode[1];
            this.next=new bpnode[1];
            next[0]=null;
            parentpointer[0]=null;
        }
    }
    int countnode=0;

    bpnode head = new bpnode(1);
    bpnode root= new bpnode(1);

/********************************* ( DELETE OPERATION WILL BE ADDED SOON!! ) ************************************

    public void deleteanode(int n,int order){
        countnode--;
        bpnode delete= new bpnode(order);
        bpnode deletet=new bpnode(order);
        deletet=head.next[0];
        int t=0;
        int tpp=0;
        while(t<n-1){
            deletet=deletet.next[0];
            t++;
        }
        delete=deletet.next[0];
        bpnode deletehelp= new bpnode(order);
        deletehelp= delete.next[0];
        deletet.next[0]=deletehelp;
        
        
        int temp[]=new int[delete.i];
        for(int c=0; c<deletet.i;c++){
            temp[c]=delete.data[c];
            tpp++;
        }
        deletet=delete.parentpointer[0];
        delete.parentpointer[0]=null;
        while(deletet.parentpointer[0]!=null){
            for(int b=0; b<deletet.i;b++){
                for(int d=0; d<tpp; d++){
                    if(deletet.data[b]==temp[d]){
                        int tp=deletet.i;
                        while(tp-1-b!=0){
                            deletet.data[b]=deletet.data[b+1];
                            deletet.childpointer[b+1]=deletet.childpointer[b+2];
                            deletet.i--;
                            b++;
                        }
                    }
                }
            }
            deletet=deletet.parentpointer[0];
        }


    }
    */
    public void  insertdatainaninternalnode(bpnode z,bpnode y, int order, int key)
    {
        if(z.i == order-1){
            if(z.parentpointer[0]==null){
                countnode++;
                countnode++;
            z.data[order-1]=key;
            z.childpointer[order] =y;
            sort(z,order);
            z.i++;
            bpnode x=new bpnode(order);
            bpnode xx= new bpnode(order);
            
            root.next[0]=xx;
            int k= order;
            if(k%2==0){
                int r= k/2;
                xx.data[0]= z.data[(order)/2];
                for(int i=0;i<r-1;i++){
                    x.data[i] =z.data[1+(i+(order/2))];
                    z.i--;
                    x.i++;
                    x.childpointer[i+1]=z.childpointer[2+(i+(order/2))];
                }
                x.childpointer[0]=z.childpointer[r+1];
                xx.childpointer[0]=z;
            xx.childpointer[1]=x;
            z.parentpointer[0]=xx;
            x.parentpointer[0]= xx;            
            return ;
            }
            else{
                int e= (k+1)/2;
                xx.data[0]= z.data[e-1];
                for(int i=0;i<e-1;i++){
                    x.data[i] =z.data[(i+e)];
                    x.i++;
                    z.i--;
                    x.childpointer[i+1]=z.childpointer[1+(i+e)];
                }
                x.childpointer[0]=z.childpointer[e];
                xx.childpointer[0]=z;
            xx.childpointer[1]=x;
            z.parentpointer[0]= xx;
            x.parentpointer[0]= xx;
            return;

            }
            
            }

            else if(z.parentpointer[0]!=null){
            countnode++;
            bpnode x=new bpnode(order);
            z.data[order-1]=key;
            z.childpointer[order]=x;
            sort(z,order);
            z.i++;
            bpnode xx= new bpnode(order);
            xx= z.parentpointer[0];
            int k= order;
            if(k%2==0){         
                int r= k/2;
                if(xx.i== order-1){
                        for(int i=0;i<r-1;i++){
                        x.data[i] =z.data[1+(i+(order/2))];
                        z.i--;
                        x.i++;
                        x.childpointer[i+1]=z.childpointer[2+(i+(order/2))];
                    }
                    x.childpointer[0]=z.childpointer[r+1];
                    x.parentpointer[0]=xx;

                    insertdatainaninternalnode(xx,x,order,z.data[(order)/2]);

                }
                else{
                    xx.data[xx.i]= z.data[((order)/2)];
                    xx.childpointer[xx.i +1]= x;
                    xx.i++;
                    sort(xx,order);
                    for(int i=0;i<r-1;i++){
                        x.data[i] =z.data[1+(i+(order/2))];
                        z.i--;
                        x.i++;
                        x.childpointer[i+1]=z.childpointer[2+(i+(order/2))];
                    }
                    x.childpointer[0]=z.childpointer[r+1];
                    x.parentpointer[0]=xx;
                }
            }


            else{
                int e= (k+1)/2;
                if(xx.i== order-1){

                    for(int i=0;i<e-1;i++){
                        x.data[i] =z.data[(i+e)];
                        x.i++;
                        z.i--;
                        x.childpointer[i+1]=z.childpointer[i+1+e];
                    }
                    x.childpointer[0]=z.childpointer[e];
                    x.parentpointer[0]=xx;
                    insertdatainaninternalnode(xx, x, order,z.data[e-1]);

                }
                else{
                    xx.data[xx.i]=z.data[e-1];
                    xx.childpointer[xx.i +1]=x;
                    sort(xx, order);
                    xx.i++;
                    for(int i=0;i<e-1;i++){
                        x.data[i] =z.data[(i+e)];
                        x.i++;
                        z.i--;
                        x.childpointer[i+1]=z.childpointer[i+1+e];
                    }
                    x.childpointer[0]=z.childpointer[e];
                    x.parentpointer[0]=xx;
                    return;
                    }
                }
                return;
            }
        }
        else{
            z.childpointer[z.i +1]=y;
            z.data[z.i]=y.data[0];
            sort(z,order);
            z.i++;
            return;
        }
    }

    public void splitleafnodeandinsert(bpnode node,int order,int key)
    {
        if(node.parentpointer[0]==null){
            bpnode y=new bpnode(order);
            countnode++;
            countnode++;
            y.next[0]=node.next[0];
            bpnode z=new bpnode(order);
            int k = order;
            root.next[0]=z;
            if(k%2==0){
                int r = k/2;
                for(int j=0; j< r;j++){
                    y.data[j]=node.data[j+((order/2))];
                    node.i= node.i - 1;
                    y.i++;
                    y.childpointer[j+1]=node.childpointer[j+(2+(order/2))];
                    }
            }
            else{
                int e= (k+1)/2;
                for(int j=0; j<e;j++){
                    y.data[j]=node.data[j+((1+order)/2)-1];
                    node.i--;
                    y.i++;
                    y.childpointer[j+1]=node.childpointer[j+1+((1+order)/2)];
                    }
            }
            node.next[0]=y;
            z.data[0]=y.data[0];
            z.i++;
            node.parentpointer[0]=z;
            y.parentpointer[0]=z;
            z.childpointer[0]=node;
            z.childpointer[1]=y;
            return ;
        } 
        else{
            countnode++;
            bpnode a=new bpnode(order);
            a.next[0]=node.next[0];
            bpnode p=new bpnode(order);
            p=node.parentpointer[0];
            int k=order;

            if(k%2==0){
                for(int j=0; j<order-2;j++){
                    a.data[j]=node.data[j+((order/2))];
                    node.i= node.i - 1;
                    a.i++;
                    a.childpointer[j+1]=node.childpointer[j+(2+(order/2))];
                    }
                    insertdatainaninternalnode(p,a,order,a.data[0]);
                    node.next[0]=a;
                    a.parentpointer[0]=p;
            return;
            }
            else{
                for(int j=0; j<=order-2;j++){
                    a.data[j]=node.data[j+((1+order)/2)-1];
                    node.i--;
                    a.i++;
                    a.childpointer[j+1]=node.childpointer[j+1+((1+order)/2)];
                    }
                    insertdatainaninternalnode(p,a,order,a.data[0]);
                    node.next[0]=a;
                    a.parentpointer[0]=p;
            return;
                    
            }
            
        }

    }
    
        
    

    public void sort(bpnode node, int order){
        int temp;
        for (int t = 0; t < node.i +1; t++){
            for (int j = 0; j < node.i - t ; j++){
                if (node.data[j] > node.data[j + 1]){
                    temp = node.data[j];   
                    node.data[j]= node.data[j+1];
                    node.data[j+1]= temp;

                    node.childpointer[order+1]= node.childpointer[j+1];
                    node.childpointer[j+1]=node.childpointer[j+2];
                    node.childpointer[j+2]=node.childpointer[order+1];
                }
            }
        }
        return;
    }

    public void count(){
        System.out.println(countnode);
    }

    public void findandinsert(bpnode node, int order,int key){
        node.data[node.i]=key;
        sort(node, order);
        node.i= node.i +1;
        return;

    }


    public void insertatleaf(int order,boolean isnonode){
        bpnode cuurentnode= new bpnode(order);
        bpnode temp= new bpnode(order);
        if(isnonode==true){
            countnode++;
        bpnode node=new  bpnode(order);
        System.out.println("Enter the data: ");
        int key=input.nextInt();
        node.data[0]=key;
        head.next[0]= node;
        node.i= node.i + 1;
        root.next[0]=node;
        return;
        }

        else if(isnonode==false){
            System.out.println("Enter the data: ");
            int key=input.nextInt();
            cuurentnode= head.next[0];
            temp= cuurentnode.next[0];
            while(cuurentnode!= null){
                if((cuurentnode.data[0]<= key) && (temp != null) && (temp.data[0] > key)  ) 
                {
                    if(cuurentnode.i==order-1){
                        cuurentnode.data[cuurentnode.i ]=key;
                        sort(cuurentnode,order);
                        cuurentnode.i++;
                        splitleafnodeandinsert(cuurentnode, order, key);
                        return;
                    }
                    else{
                        findandinsert(cuurentnode, order, key);
                        return;
                    }
                }
                else if(temp == null){
                    if(cuurentnode.i == (order-1)){
                        cuurentnode.data[order-1]=key;
                        sort(cuurentnode,order);   
                        cuurentnode.i++; 
                        splitleafnodeandinsert(cuurentnode, order, key);
                        return;
                    }
                    else{
                        findandinsert(cuurentnode, order, key);
                       
                    }
                    return;

                }
                else if((cuurentnode.data[0]< key) &&(temp.data[0]> key)&& (temp != null)){
                    if(cuurentnode.i == (order-1)){
                        cuurentnode.data[order-1]=key;
                        sort(cuurentnode,order);   
                        cuurentnode.i++; 
                        splitleafnodeandinsert(cuurentnode, order, key);
                        return;
                    }
                    else{
                        findandinsert(cuurentnode, order, key);
                       
                    }
                    return;
                }
                    
                else{               
                    temp=temp.next[0];
                    cuurentnode= cuurentnode.next[0];
 
                }

            }
            return;
        }
    }

    public void countlevel(int order){
        int count=0;
        bpnode cnode=new bpnode(order);
        cnode=head.next[0];
        while(cnode.parentpointer[0]!=null){
            count++;
            cnode=cnode.parentpointer[0];
        }
        System.out.println(count);
    }

    public void display(int order){
        bpnode currnode= new bpnode(order);
        currnode = head.next[0];
        while(currnode !=null){
            for(int j=0; j<currnode.i; j++){
                System.out.print(currnode.data[j]+", ");
            }
                System.out.print("  =>");

            currnode= currnode.next[0];
        }
    }
    public void search(int order){
        System.out.println("Enter an element to be searched: ");
        int key=input.nextInt();
        bpnode currnode= new bpnode(order);
        currnode = head.next[0];
        while(currnode !=null){
            for(int j=0; j<currnode.i; j++){
                if(currnode.data[j]==key){
                    System.out.println("Element found");
                    return;
                }
                
            }


            currnode= currnode.next[0];
        }
        System.out.println("Element not found\n");
        return;

        
    }
    public static void main(String[] args) {
        Scanner i=new Scanner(System.in);
        bptreeone op=new bptreeone();
        int choice;
        System.out.println("Enter the degree of the b+ tree: ");
        int order=i.nextInt();
        int a=0;
        boolean isnonode;
        do{
            
            System.out.println("Enter an operation to be performed: ");
            System.out.println("\n1)Insert \n2)Search \n3)count no of levels \n4)count no of nodes \n5)Display \n6)exit");
            choice= i.nextInt();
            switch(choice){
                case 1:{
                    
                    
                        if( a>=1){
                            isnonode= false;
                        }
                        else{
                            isnonode= true;
                            a++;
                        }
                        
                        op.insertatleaf(order,isnonode);
                        break;
                        
                  }
                
                        
                case 2:{
                     op.search(order);
                    break;
                }

                case 3:{
                    op.countlevel(order);
                    break;
                }
                case 4:{
                    op.count();
                }
                
                case 5:{
                    op.display(order);
                    break;
                }

                /*case 6:{
                    op.display(order);
                    System.out.println("enter the node number to be deleted: ");
                    int val=i.nextInt();
                    op.deleteanode(val, order);
                }*/
            }
        }while(choice!=6);
    }
        
}


   