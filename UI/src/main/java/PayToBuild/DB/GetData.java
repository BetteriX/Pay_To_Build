package PayToBuild.DB;

import PayToBuild.Data.*;

import java.net.MalformedURLException;
import java.net.URL;
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


    public static List<CPU> Get_Processor_Data(ResultSet resultSet) throws SQLException, MalformedURLException {
        List<CPU> cpuList = new ArrayList<>();

        while (resultSet.next()) {

            String imageStr = resultSet.getString("image");
            URL imageUrl;

            if (imageStr == null || imageStr.isBlank()) {
                imageUrl = new URL("https://upload.wikimedia.org/wikipedia/commons/a/a3/Image-not-found.png");
            } else {
                imageUrl = new URL(imageStr);
            }

            CPU cpu = new CPU(
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    imageUrl,
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

    public static List<Case> Get_Case_Data(ResultSet resultSet) throws SQLException, MalformedURLException {
        List<Case> caseList = new ArrayList<>();

        while (resultSet.next()) {

            String imageStr = resultSet.getString("image");
            URL imageUrl;

            if (imageStr == null || imageStr.isBlank()) {
                imageUrl = new URL("https://upload.wikimedia.org/wikipedia/commons/a/a3/Image-not-found.png");
            } else {
                imageUrl = new URL(imageStr);
            }

            Case pcCase = new Case(
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    imageUrl,
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

    public static List<CPUCooler> Get_CPUCooler_Data(ResultSet resultSet) throws SQLException, MalformedURLException {
        List<CPUCooler> coolerList = new ArrayList<>();

        while (resultSet.next()) {

            String imageStr = resultSet.getString("image");
            URL imageUrl;

            if (imageStr == null || imageStr.isBlank()) {
                imageUrl = new URL("https://upload.wikimedia.org/wikipedia/commons/a/a3/Image-not-found.png");
            } else {
                imageUrl = new URL(imageStr);
            }

            CPUCooler cooler = new CPUCooler(
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    imageUrl,
                    resultSet.getString("rpm"),
                    resultSet.getInt("size"),
                    resultSet.getString("noise_level"),
                    resultSet.getString("color")
            );

            coolerList.add(cooler);
        }

        return coolerList;
    }

    public static List<Memory> Get_Memory_Data(ResultSet resultSet) throws SQLException, MalformedURLException {
        List<Memory> memoryList = new ArrayList<>();

        while (resultSet.next()) {

            String imageStr = resultSet.getString("image");
            URL imageUrl;

            if (imageStr == null || imageStr.isBlank()) {
                imageUrl = new URL("https://upload.wikimedia.org/wikipedia/commons/a/a3/Image-not-found.png");
            } else {
                imageUrl = new URL(imageStr);
            }

            Memory memory = new Memory(
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    imageUrl,
                    resultSet.getString("speed"),
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

    public static List<Motherboard> Get_Motherboard_Data(ResultSet resultSet) throws SQLException, MalformedURLException {
        List<Motherboard> motherboardList = new ArrayList<>();

        while (resultSet.next()) {

            String imageStr = resultSet.getString("image");
            URL imageUrl;

            if (imageStr == null || imageStr.isBlank()) {
                imageUrl = new URL("https://upload.wikimedia.org/wikipedia/commons/a/a3/Image-not-found.png");
            } else {
                imageUrl = new URL(imageStr);
            }

            Motherboard motherboard = new Motherboard(
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    imageUrl,
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

    public static List<PSU> Get_PSU_Data(ResultSet resultSet) throws SQLException, MalformedURLException {
        List<PSU> psuList = new ArrayList<>();

        while (resultSet.next()) {

            String imageStr = resultSet.getString("image");
            URL imageUrl;

            if (imageStr == null || imageStr.isBlank()) {
                imageUrl = new URL("https://upload.wikimedia.org/wikipedia/commons/a/a3/Image-not-found.png");
            } else {
                imageUrl = new URL(imageStr);
            }

            PSU psu = new PSU(
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    imageUrl,
                    resultSet.getInt("capacity_w"),
                    resultSet.getInt("capacity_va")
            );

            psuList.add(psu);
        }

        return psuList;
    }

    public static List<Storage> Get_Storage_Data(ResultSet resultSet) throws SQLException, MalformedURLException {
        List<Storage> storageList = new ArrayList<>();

        while (resultSet.next()) {

            String imageStr = resultSet.getString("image");
            URL imageUrl;

            if (imageStr == null || imageStr.isBlank()) {
                imageUrl = new URL("https://upload.wikimedia.org/wikipedia/commons/a/a3/Image-not-found.png");
            } else {
                imageUrl = new URL(imageStr);
            }

            Storage storage = new Storage(
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    imageUrl,
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

    public static List<VideoCard> Get_VideoCard_Data(ResultSet resultSet) throws SQLException, MalformedURLException {
        List<VideoCard> videoCards = new ArrayList<>();

        while (resultSet.next()) {

            String imageStr = resultSet.getString("image");
            URL imageUrl;

            if (imageStr == null || imageStr.isBlank()) {
                imageUrl = new URL("https://upload.wikimedia.org/wikipedia/commons/a/a3/Image-not-found.png");
            } else {
                imageUrl = new URL(imageStr);
            }

            VideoCard vc = new VideoCard(
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    imageUrl,
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