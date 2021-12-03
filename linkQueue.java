package lista.exe.trabalho_estrutura;
// linkQueue.java

// demonstrates queue implemented as double-ended list
// to run this program: C>java LinkQueueApp
////////////////////////////////////////////////////////////////

class Link extends Tabela {
	public Tabela dData; // data item
	public Link next; // next link in list
// -------------------------------------------------------------

	public Link(Tabela d) 						// constructor
	{
		dData = d;
	}

// -------------------------------------------------------------
	public void displayLink() // display this link
	{
		System.out.print(dData + " ");
	}
// -------------------------------------------------------------
} // end class Link
////////////////////////////////////////////////////////////////

class FirstLastList {
	private Link first; // ref to first item
	private Link last; // ref to last item
// -------------------------------------------------------------

	public FirstLastList() // constructor
	{
		first = null; // no items on list yet
		last = null;
	}

// -------------------------------------------------------------
	public boolean isEmpty() // true if no links
	{
		return first == null;
	}

// -------------------------------------------------------------
	public void insertLast(Tabela dd) // insert at end of list
	{
		if (dd.getPrioridade() < 0) {
			Link newLink = new Link(dd); // make new link
			if (isEmpty()) // if empty list,
				first = newLink; // first --> newLink
			else
				last.next = newLink; // old last --> newLink
			last = newLink; // newLink <-- last
		}
	}

// -------------------------------------------------------------
	public void furafila(Tabela dd) 				// Fura fila
	{
		if (dd.getPrioridade() > 0) {
			Link newLink = new Link(dd);
			newLink.next = first;
			first = newLink; 						// inserir no comeco da fila
		} else {
			Link newLink = new Link(dd);
			if (isEmpty())
				first = newLink;
			else
				last.next = newLink;
			last = newLink;
		}
	}

// -------------------------------------------------------------
	public Tabela deleteFirst() // delete first link
	{ // (assumes non-empty list)
		Tabela temp = first.dData;
		if (first.next == null) // if only one item
			last = null; // null <-- last
		first = first.next; // first --> old next
		return temp;
	}

// -------------------------------------------------------------
	public void displayList() {
		System.out.println("");
		Link current = first; // start at beginning
		while (current != null) // until end of list,
		{
			current.displayLink(); // print data
			current = current.next; // move to next link
			System.out.println("");
		}
		System.out.println("");
	}

// -------------------------------------------------------------
	public void insertLast(String string, String string2, int i) {

	}
} // end class FirstLastList
////////////////////////////////////////////////////////////////

class LinkQueue {
	private FirstLastList theList;

//--------------------------------------------------------------
	public LinkQueue() // constructor
	{
		theList = new FirstLastList();
	} // make a 2-ended list
//--------------------------------------------------------------

	public void furafila(Tabela i) { // Para acessar os metodos
		theList.furafila(i);
	}

//--------------------------------------------------------------
	public boolean isEmpty() // true if queue is empty
	{
		return theList.isEmpty();
	}

//--------------------------------------------------------------
	public void insert(Tabela j) // insert, rear of queue
	{
		theList.insertLast(j);
	}

//--------------------------------------------------------------
	public Tabela remove() // remove, front of queue
	{
		return theList.deleteFirst();
	}

//--------------------------------------------------------------
	public void displayQueue() {
		System.out.print("Listando): ");
		theList.displayList();
		System.out.println();
	}

//--------------------------------------------------------------
	public void insert(String string, String string2, int i) {
		theList.insertLast(string, string2, i);

	}
} // end class LinkQueue
////////////////////////////////////////////////////////////////

class LinkQueueApp {
	public static void main(String[] args) {
		LinkQueue theQueue = new LinkQueue();
		
		theQueue.displayQueue(); // display queue
		
	} // end main()
} // end class LinkQueueApp
////////////////////////////////////////////////////////////////
