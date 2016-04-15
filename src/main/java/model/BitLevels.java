package model;

import java.util.Iterator;
import java.util.List;



public class BitLevels implements Iterable<BitLevel>{

    List<BitLevel> bitLevels;



    public BitLevels()
    {
    }



    public List<BitLevel> getBitLevels() {
        return bitLevels;
    }



    public void setBitLevels(List<BitLevel> bitLevels) {
        this.bitLevels = bitLevels;
    }



    public void addBitLevel(BitLevel bitlevel)
    {
        this.bitLevels.add(bitlevel);
    }



    public String getBitsByLevel(int level)
    {
        for (BitLevel bitlevel : this.bitLevels)
        {
            if (bitlevel.getLevel() == level)
            {
                return bitlevel.getBits();
            }
        }

        return null;        // Vai mitä tän pitäis antaa jos on virheellinen level kysytty?
    }



    @Override
    public Iterator<BitLevel> iterator() {
        return bitLevels.iterator();
    }
}
