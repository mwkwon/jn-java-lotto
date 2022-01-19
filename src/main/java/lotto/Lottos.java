package lotto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public Lottos(Lottos lottos) {
        this.lottos = new ArrayList<>(lottos.lottos);
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
