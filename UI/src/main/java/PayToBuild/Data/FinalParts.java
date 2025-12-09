package PayToBuild.Data;

public class FinalParts {
    CPU _cpu ;
    Motherboard _motherboard;
    Memory _memory;
    VideoCard _videocard;
    CPUCooler _cpucooler;
    PSU _psu;
    Storage _storage;
    Case _case;

    public CPU get_cpu() {
        return _cpu;
    }

    public void set_cpu(CPU _cpu) {
        this._cpu = _cpu;
    }

    public Motherboard get_motherboard() {
        return _motherboard;
    }

    public void set_motherboard(Motherboard _motherboard) {
        this._motherboard = _motherboard;
    }

    public Memory get_memory() {
        return _memory;
    }

    public void set_memory(Memory _memory) {
        this._memory = _memory;
    }

    public VideoCard get_videocard() {
        return _videocard;
    }

    public void set_videocard(VideoCard _videocard) {
        this._videocard = _videocard;
    }

    public CPUCooler get_cpucooler() {
        return _cpucooler;
    }

    public void set_cpucooler(CPUCooler _cpucooler) {
        this._cpucooler = _cpucooler;
    }

    public PSU get_psu() {
        return _psu;
    }

    public void set_psu(PSU _psu) {
        this._psu = _psu;
    }

    public Storage get_storage() {
        return _storage;
    }

    public void set_storage(Storage _storage) {
        this._storage = _storage;
    }

    public Case get_case() {
        return _case;
    }

    public void set_case(Case _case) {
        this._case = _case;
    }
}
