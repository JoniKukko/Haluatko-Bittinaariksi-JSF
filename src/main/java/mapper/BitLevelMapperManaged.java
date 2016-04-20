package mapper;


import interfaces.IBitLevelMapper;
import model.BitLevel;
import model.BitLevels;

public class BitLevelMapperManaged implements IBitLevelMapper {
    private BitLevels repository;



    public BitLevelMapperManaged() {
        this.repository = new BitLevels();

        this.repository.addBitLevel(new BitLevel(0, "0 b"));
        this.repository.addBitLevel(new BitLevel(1, "500 b"));
        this.repository.addBitLevel(new BitLevel(2, "1 kb"));
        this.repository.addBitLevel(new BitLevel(3, "2,5 kb"));
        this.repository.addBitLevel(new BitLevel(4, "5 kb"));
        this.repository.addBitLevel(new BitLevel(5, "10 kb"));
        this.repository.addBitLevel(new BitLevel(6, "15 kb"));
        this.repository.addBitLevel(new BitLevel(7, "30 kb"));
        this.repository.addBitLevel(new BitLevel(8, "50 kb"));
        this.repository.addBitLevel(new BitLevel(9, "75 kb"));
        this.repository.addBitLevel(new BitLevel(10, "100 kb"));
        this.repository.addBitLevel(new BitLevel(11, "150 kb"));
        this.repository.addBitLevel(new BitLevel(12, "250 kb"));
        this.repository.addBitLevel(new BitLevel(13, "350 kb"));
        this.repository.addBitLevel(new BitLevel(14, "500 kb"));
        this.repository.addBitLevel(new BitLevel(15, "1 Mb"));
    }



    public BitLevels getRepository() {
        return repository;
    }

}
