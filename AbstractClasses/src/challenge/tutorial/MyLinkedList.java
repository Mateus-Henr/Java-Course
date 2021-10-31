package challenge.tutorial;

public class MyLinkedList implements NodeList
{
    private ListItem root = null;

    public MyLinkedList(ListItem root)
    {
        this.root = root;
    }

    @Override
    public ListItem getRoot()
    {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem)
    {
        if (this.root == null)
        {
            // The list was empty, so this item becomes the head of the list
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null)
        {
            int comparison = (currentItem.compareTo(newItem));
            if (comparison < 0)
            {
                // newItem is greater, move right if possible
                if (currentItem.next() != null)
                {
                    currentItem = currentItem.next();
                }
                else
                {
                    // There is no next, so insert at end of list
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);
                    return true;
                }
            }
            else if (comparison > 0)
            {
                // newItem is less, insert before
                if (currentItem.previous() != null)
                {
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);
                }
            }
        }

        return false;
    }

    @Override
    public boolean removeItem(ListItem item)
    {
        return false;
    }

    @Override
    public void traverse(ListItem item)
    {

    }

}
