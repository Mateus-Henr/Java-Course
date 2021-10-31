package challenge.mine.first;

import java.util.List;

public interface Saveable
{
    void save(Saveable storageMedium);

    List<Saveable> read();

}
