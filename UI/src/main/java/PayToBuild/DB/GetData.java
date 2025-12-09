package PayToBuild.DB;

import PayToBuild.Data.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class GetData {

    private static final Map<String, List<String>> socketToMicroarch = Map.of(
            "AM4", List.of("Zen","Zen+","Zen 2","Zen 3","Zen 3D"),
            "AM5", List.of("Zen 4","Zen 4c","Zen 4 (3D V-Cache)","Zen 5","Zen 5c"),
            "LGA1151", List.of("Skylake","Kaby Lake","Coffee Lake"),
            "LGA1200", List.of("Comet Lake","Rocket Lake"),
            "LGA1700", List.of("Alder Lake","Raptor Lake","Raptor Lake Refresh"),
            "LGA1851", List.of("Arrow Lake","Panther Lake"),
            "sTRX4", List.of("Zen 2 Threadripper","Zen 3 Threadripper"),
            "LGA1150", List.of("Haswell","Broadwell"),
            "LGA775", List.of("NetBurst","Core 2")
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
                    null, // egyelőre nincs URL
                    resultSet.getString("color"),
                    resultSet.getString("type"),
                    resultSet.getInt("psu_watt"),
                    resultSet.getFloat("external_volume"),
                    resultSet.getString("side_panel"),
                    resultSet.getInt("internal_35_bay")
            );

            caseList.add(pcCase);
        }

        return caseList;
    }

    public static List<CPUCooler> Get_Cooler_Data(ResultSet resultSet) throws SQLException {
        List<CPUCooler> coolerList = new ArrayList<>();

        while (resultSet.next()) {

            String noiseString = resultSet.getString("noise_level");
            List<Float> noiseList = new ArrayList<>();

            if (noiseString != null && !noiseString.isEmpty()) {
                String[] parts = noiseString.split(",");
                for (String p : parts) {
                    try {
                        noiseList.add(Float.parseFloat(p.trim()));
                    } catch (NumberFormatException ignored) { }
                }
            }

            CPUCooler cooler = new CPUCooler(
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    null, // egyelőre nincs URL
                    resultSet.getInt("rpm"),
                    resultSet.getInt("size"),
                    noiseList,
                    resultSet.getString("color")
            );

            coolerList.add(cooler);
        }

        return coolerList;
    }

    public static List<Memory> Get_Memory_Data(ResultSet resultSet) throws SQLException {
        List<Memory> memoryList = new ArrayList<>();

        while (resultSet.next()) {

            String colorString = resultSet.getString("color");
            List<String> colorList = new ArrayList<>();

            if (colorString != null && !colorString.isEmpty()) {
                String[] parts = colorString.split(",");
                for (String p : parts) {
                    String trimmed = p.trim();
                    if (!trimmed.isEmpty()) {
                        colorList.add(trimmed);
                    }
                }
            }

            Memory memory = new Memory(
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    null, // egyelőre nincs URL
                    resultSet.getInt("speed"),
                    resultSet.getInt("ddr"),
                    resultSet.getFloat("price_p_rgb"),
                    resultSet.getString("modules"),
                    colorList,
                    resultSet.getFloat("fw_latency"),
                    resultSet.getFloat("cas_latency")
            );

            memoryList.add(memory);
        }

        return memoryList;
    }

    public static List<Motherboard> Get_Motherboard_Data(ResultSet resultSet) throws SQLException {
        List<Motherboard> motherboardList = new ArrayList<>();

        while (resultSet.next()) {

            String colorString = resultSet.getString("color");
            List<String> colorList = new ArrayList<>();

            if (colorString != null && !colorString.isEmpty()) {
                String[] parts = colorString.split(",");
                for (String p : parts) {
                    String trimmed = p.trim();
                    if (!trimmed.isEmpty()) {
                        colorList.add(trimmed);
                    }
                }
            }

            Motherboard mb = new Motherboard(
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    null, // nincs URL
                    resultSet.getString("socket"),
                    resultSet.getInt("memory_slots"),
                    resultSet.getInt("max_supported_memory"),
                    resultSet.getString("form_factor"),
                    colorList
            );

            motherboardList.add(mb);
        }

        return motherboardList;
    }

    public static List<PSU> Get_PSU_Data(ResultSet resultSet) throws SQLException {
        List<PSU> psuList = new ArrayList<>();

        while (resultSet.next()) {

            String colorString = resultSet.getString("color");
            List<String> colorList = new ArrayList<>();

            if (colorString != null && !colorString.isEmpty()) {
                String[] parts = colorString.split(",");
                for (String p : parts) {
                    String trimmed = p.trim();
                    if (!trimmed.isEmpty()) {
                        colorList.add(trimmed);
                    }
                }
            }

            PSU psu = new PSU(
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    null, // egyelőre nincs URL kezelve
                    resultSet.getInt("wattage"),
                    colorList,
                    resultSet.getString("modular"),
                    resultSet.getString("efficiency_rate")
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
                    null, // egyelőre nincs URL
                    resultSet.getString("type"),
                    resultSet.getString("form_factor"),
                    resultSet.getInt("capacity"),
                    resultSet.getFloat("price_p_rgb"),
                    resultSet.getInt("cache"),
                    resultSet.getString("drive_interface")
            );

            storageList.add(storage);
        }

        return storageList;
    }


    public static List<VideoCard> Get_VideoCard_Data(ResultSet resultSet) throws SQLException {
        List<VideoCard> gpuList = new ArrayList<>();

        while (resultSet.next()) {

            String colorString = resultSet.getString("color");
            List<String> colorList = new ArrayList<>();

            if (colorString != null && !colorString.isEmpty()) {
                String[] parts = colorString.split(",");
                for (String p : parts) {
                    String trimmed = p.trim();
                    if (!trimmed.isEmpty()) {
                        colorList.add(trimmed);
                    }
                }
            }

            VideoCard gpu = new VideoCard(
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    null, // egyelőre nincs URL
                    resultSet.getInt("memory"),
                    colorList,
                    resultSet.getInt("core_clock"),
                    resultSet.getInt("boost_clock"),
                    resultSet.getInt("length"),
                    resultSet.getString("chipset")
            );

            gpuList.add(gpu);
        }

        return gpuList;
    }


}

