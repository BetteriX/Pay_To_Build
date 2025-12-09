package PayToBuild.DB;

import PayToBuild.Data.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class GetData {

    private static final Map<String, List<String>> socketToMicroarch = Map.of(
            "AM4", List.of("Zen", "Zen+", "Zen 2", "Zen 3", "Zen 3D"),
            "AM5", List.of("Zen 4", "Zen 4c", "Zen 4 (3D V-Cache)", "Zen 5", "Zen 5c"),
            "LGA1151", List.of("Skylake", "Kaby Lake", "Coffee Lake"),
            "LGA1200", List.of("Comet Lake", "Rocket Lake"),
            "LGA1700", List.of("Alder Lake", "Raptor Lake", "Raptor Lake Refresh"),
            "LGA1851", List.of("Arrow Lake", "Panther Lake"),
            "sTRX4", List.of("Zen 2 Threadripper", "Zen 3 Threadripper"),
            "LGA1150", List.of("Haswell", "Broadwell"),
            "LGA775", List.of("NetBurst", "Core 2")
    );

    public static List<String> getMicroarchitectures(String socket) {
        return socketToMicroarch.getOrDefault(socket.trim().toUpperCase(), List.of());
    }


    public static List<CPU> Get_Processor_Data(ResultSet resultSet) throws SQLException {
        List<CPU> cpuList = new ArrayList<>();

        while (resultSet.next()) {

            CPU cpu = new CPU(
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    null, // no URL for now
                    resultSet.getInt("core_count"),
                    resultSet.getFloat("core_clock"),
                    resultSet.getFloat("boost_clock"),
                    resultSet.getString("microarchitecture"),
                    resultSet.getInt("tdp"),
                    resultSet.getString("graphics")
            );

            cpuList.add(cpu);
        }

        return cpuList;
    }

    public static List<Case> Get_Case_Data(ResultSet resultSet) throws SQLException {
        List<Case> caseList = new ArrayList<>();

        while (resultSet.next()) {

            Case pcCase = new Case(
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    null, // nincs URL adat
                    resultSet.getString("color"),
                    resultSet.getString("type"),
                    resultSet.getInt("psu"),
                    resultSet.getFloat("external_volume"),
                    resultSet.getString("side_panel"),
                    resultSet.getInt("internal_35_bays")
            );

            caseList.add(pcCase);
        }

        return caseList;
    }

    public static List<CPUCooler> Get_CPUCooler_Data(ResultSet resultSet) throws SQLException {
        List<CPUCooler> coolerList = new ArrayList<>();

        while (resultSet.next()) {

            CPUCooler cooler = new CPUCooler(
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    null, // nincs URL adat
                    resultSet.getInt("rpm"),
                    resultSet.getInt("size"),
                    resultSet.getString("noise_level"),
                    resultSet.getString("color")
            );

            coolerList.add(cooler);
        }

        return coolerList;
    }

    public static List<Memory> Get_Memory_Data(ResultSet resultSet) throws SQLException {
        List<Memory> memoryList = new ArrayList<>();

        while (resultSet.next()) {

            Memory memory = new Memory(
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    null, // nincs URL adat
                    resultSet.getInt("speed"),
                    resultSet.getFloat("price_per_gb"),
                    resultSet.getString("modules"),
                    resultSet.getString("color"),
                    resultSet.getFloat("first_word_latency"),
                    resultSet.getFloat("cas_latency")
            );

            memoryList.add(memory);
        }

        return memoryList;
    }

    public static List<Motherboard> Get_Motherboard_Data(ResultSet resultSet) throws SQLException {
        List<Motherboard> motherboardList = new ArrayList<>();

        while (resultSet.next()) {

            Motherboard motherboard = new Motherboard(
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    null, // nincs URL adat tárolva
                    resultSet.getString("socket"),
                    resultSet.getInt("memory_slots"),
                    resultSet.getInt("max_memory"),
                    resultSet.getString("form_factor"),
                    resultSet.getString("color")
            );

            motherboardList.add(motherboard);
        }

        return motherboardList;
    }

    public static List<PSU> Get_PSU_Data(ResultSet resultSet) throws SQLException {
        List<PSU> psuList = new ArrayList<>();

        while (resultSet.next()) {

            PSU psu = new PSU(
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    null, // URL nincs tárolva
                    resultSet.getInt("capacity_w"),
                    resultSet.getInt("capacity_va")
            );

            psuList.add(psu);
        }

        return psuList;
    }

    public static List<Storage> Get_Storage_Data(ResultSet resultSet) throws SQLException {
        List<Storage> storageList = new ArrayList<>();

        while (resultSet.next()) {

            Storage storage = new Storage(
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    null, // nincs URL oszlop
                    resultSet.getString("type"),
                    resultSet.getString("form_factor"),
                    resultSet.getInt("capacity"),
                    resultSet.getFloat("price_per_gb"),
                    resultSet.getInt("cache"),
                    resultSet.getString("interface")
            );

            storageList.add(storage);
        }

        return storageList;
    }

    public static List<VideoCard> Get_VideoCard_Data(ResultSet resultSet) throws SQLException {
        List<VideoCard> videoCards = new ArrayList<>();

        while (resultSet.next()) {

            VideoCard vc = new VideoCard(
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    null, // nincs URL oszlop
                    resultSet.getInt("memory"),
                    resultSet.getString("color"),
                    resultSet.getInt("core_clock"),
                    resultSet.getInt("boost_clock"),
                    resultSet.getInt("length"),
                    resultSet.getString("chipset")
            );

            videoCards.add(vc);
        }

        return videoCards;
    }



}