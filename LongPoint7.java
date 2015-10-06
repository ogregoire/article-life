import static util.LongUtil.*;

import java.util.HashMap;
import java.util.zip.CRC32;

final class LongPoint7 extends LongPoint
{
    public static class Factory extends LongPointFactory
    {
        @Override
        public LongPoint create (long v)
        {
            return new LongPoint7 (v);
        }
    }
    
    public LongPoint7 (long v)
    {
        super (v);
    }

    @Override
    public void inc (HashMap<LongPoint, Integer> counts)
    {
        inc (counts, new LongPoint7 (v-DX-DY));
        inc (counts, new LongPoint7 (v-DX));
        inc (counts, new LongPoint7 (v-DX+DY));
        inc (counts, new LongPoint7 (v-DY));
        inc (counts, new LongPoint7 (v+DY));
        inc (counts, new LongPoint7 (v+DX-DY));
        inc (counts, new LongPoint7 (v+DX));
        inc (counts, new LongPoint7 (v+DX+DY));
    }

    @Override
    public void dec (HashMap<LongPoint, Integer> counts)
    {
        dec (counts, new LongPoint7 (v-DX-DY));
        dec (counts, new LongPoint7 (v-DX));
        dec (counts, new LongPoint7 (v-DX+DY));
        dec (counts, new LongPoint7 (v-DY));
        dec (counts, new LongPoint7 (v+DY));
        dec (counts, new LongPoint7 (v+DX-DY));
        dec (counts, new LongPoint7 (v+DX));
        dec (counts, new LongPoint7 (v+DX+DY));
    }

    @Override
    public int hashCode ()
    {
        CRC32 crc = new CRC32 ();
        crc.update ((int)(v>>> 0) & 0xFF);
        crc.update ((int)(v >>> 8) & 0xFF);
        crc.update ((int)(v >>> 16) & 0xFF);
        crc.update ((int)(v >>> 24) & 0xFF);
        crc.update ((int)(v >>> 32) & 0xFF);
        crc.update ((int)(v >>> 40) & 0xFF);
        crc.update ((int)(v >>> 48) & 0xFF);
        crc.update ((int)(v >>> 56) & 0xFF);
        return (int) crc.getValue ();
    }
}
