package PayToBuild.App;

import PayToBuild.Data.FinalParts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Label;


import java.awt.Toolkit;
import java.awt.Dimension;
import java.io.IOException;


    public class GuideController {
        private Parent root;
        private Scene scene;
        private Stage stage;

        @FXML
        private Label guideText;

        @FXML
        public void backtomain(MouseEvent event) throws IOException {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
            root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root,screenSize.width,screenSize.height);
            stage.setTitle("MainPage");
            stage.setScene(scene);
            stage.show();
            MainController controller = loader.getController();
            controller.refresh();
        }

            @FXML
            public void changecursor (MouseEvent event){
                scene = ((Node) event.getSource()).getScene();
                if (event.getEventType().equals(MouseEvent.MOUSE_ENTERED)) {
                    scene.setCursor(Cursor.HAND);
                } else if (!event.getEventType().equals(MouseEvent.MOUSE_ENTERED)) {
                    scene.setCursor(Cursor.DEFAULT);
                }

            }

        public void swaptologin(ActionEvent event) throws IOException {
            root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
            stage= (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("LoginPage");
            stage.setScene(scene);
            stage.show();
        }

        @FXML
        public void initialize() {
            guideText.setText("""
                    Útmutató: PC-alkatrészek és kompatibilitási szempontok\s
                    
                    
                    1. Processzor (CPU)\s
                    
                    A számítógép „agya”, meghatározza a teljesítményt és hogy milyen alaplapot választhatsz.\s
                    
                    Mire figyelj?\s
                    
                    Foglalat (socket): Az alaplapnak és a CPU-nak azonos foglalatúnak kell lennie\s
                    Intel például: LGA1700, AMD: AM4/AM5.\s
                    
                    Generáció / architektúra: Újabb generáció → jobb teljesítmény és hatékonyság.\s
                    
                    Magok és szálak száma:\s
                    
                    Játékra: 6–8 mag\s
                    
                    Munkára (render, programozás, videó): 8–16 mag\s
                    
                    TDP (hőtermelés): Meghatározza, milyen erős hűtő kell.\s
                    
                    2. Alaplap (Motherboard)\s
                    
                    Az összes alkatrész „központja”. Összeköti és működteti a CPU-t, RAM-ot, videókártyát, tárhelyet és minden mást.\s
                    
                    Mire figyelj?\s
                    
                    CPU foglalat: Passzoljon a választott processzorhoz.\s
                    
                    Chipset: Meghatározza a funkciókat (OC lehetőség, PCIe sávok, USB-k).\s
                    
                    Méret: ATX, mATX, ITX – a háznak megfelelő legyen.\s
                    
                    RAM támogatás: DDR4 vagy DDR5, maximális órajel, kapacitás.\s
                    
                    Bővítési lehetőségek: M.2 slotok, PCIe x16 slot a videókártyának.\s
                    
                    VRM minőség: Erősebb processzorhoz jobb VRM kell a stabilitás miatt.\s
                    
                    
                    
                    3. RAM (Memória)\s
                    
                    Rövid távú gyors tárhely. A futó programok és játékok adatai ide töltődnek, hogy a gép gyorsan hozzáférjen. Befolyásolja a többfeladatos munkát és a rendszer gyorsaságát. \s
                    
                    Mire figyelj?\s
                    
                    Típus: DDR4 vagy DDR5 (alaplap határozza meg).\s
                    
                    Kapacitás:\s
                    
                    Átlagos használatra / játékra: 16–32 GB\s
                    
                    Professzionális munkára: 32–64 GB+\s
                    
                    Órajel és késleltetés:\s
                    
                    Gyorsabb RAM → jobb teljesítmény, főleg AMD rendszereknél fontos.\s
                    
                    Kiosztás: 2 modul jobb, mint 1 (dual-channel).\s
                    
                    4. Videókártya (GPU)\s
                    
                    A grafikai megjelenítésért felel. Játékok, videóvágás, 3D programok futtatásához nélkülözhetetlen. \s
                    
                    Mire figyelj?\s
                    
                    Hossz és vastagság: Férjen el a házban.\s
                    
                    Tápcsatlakozó / fogyasztás: A táp tudja kiszolgálni (8-pin, 12VHPWR, stb.).\s
                    
                    PCIe kompatibilitás: Minden modern kártya PCIe x16, ez nem gond.\s
                    
                    VRAM mennyiség:\s
                    
                    FHD: 6–8 GB\s
                    
                    QHD/4K: 10–16 GB\s
                    
                    
                    
                    5. Tápegység (PSU)\s
                    
                    Ellátja árammal a számítógép összes alkatrészét. Stabil működéshez elengedhetetlen. \s
                    
                    Mire figyelj?\s
                    
                    Teljesítmény:\s
                    
                    Átlagos gaming PC: 550–750W\s
                    
                    Erős GPU-kkal: 750–1000W\s
                    
                    Minősítés (80+ Bronze/Gold/Platinum): A Gold ajánlott.\s
                    
                    Csatlakozók: A GPU és alaplap igényeinek megfelelő legyen.\s
                    
                    Moduláris kábelezés: Tisztább, könnyebb szerelés.\s
                    
                    6. Tárhely (SSD / HDD)\s
                    
                    Itt tárolódik minden: az operációs rendszer, játékok és fájlok. Az SSD gyors, a HDD nagy kapacitású. Az operációs rendszer és programok gyorsaságát nagyban befolyásolja.\s
                    
                    Mire figyelj?\s
                    
                    Típusok:\s
                    
                    SATA SSD: olcsóbb, lassabb\s
                    
                    NVMe M.2 SSD: gyorsabb, ajánlott\s
                    
                    Sebesség: PCIe 3.0 / 4.0 / 5.0 – játékra 3.0/4.0 bőven elég.\s
                    
                    Kapacitás:\s
                    
                    Minimum: 500 GB\s
                    
                    Optimális: 1–2 TB\s
                    
                    
                    
                    
                    
                    
                    7. Ház (Case)\s
                    
                    Tartja és védi az alkatrészeket, valamint biztosítja a légáramlást és a hűtést.\s
                    
                    Mire figyelj?\s
                    
                    Méret: ATX / mATX / ITX – illeszkedjen az alaplaphoz.\s
                    
                    GPU és CPU hűtő hely: Hossz, magasság.\s
                    
                    Légáramlás: Mesh elejű házak jobbak a hűtésben.\s
                    
                    Ventilátorok helye és száma.\s
                    
                    8. Hűtés (CPU hűtő vagy AIO)\s
                    
                    A processzor hőmérsékletét szabályozza, hogy ne melegedjen túl működés közben. A hőmérséklet és zajszint miatt fontos.\s
                    
                    Mire figyelj?\s
                    
                    Kompatibilitás: Foglalathoz illeszkedjen (Intel/AMD).\s
                    
                    Méret: Elférjen a házban.\s
                    
                    Típus:\s
                    
                    Lég hűtő: megbízható, olcsó\s
                    
                    AIO vízhűtés: jobb hőfok, de drágább\s
                    
                    9. Összeszerelés (Bemutatása videón keresztül)\s
                    
                    Az alábbi videó segítségével lépésről lépésre megtekintheti, hogyan történik a számítógép alkatrészeinek szakszerű összeszerelése. A videó bepillantást nyújt a teljes folyamatba, az alkatrészek előkészítésétől egészen a kész rendszer összeállításáig.\s
                    
                    Videó: “https://www.youtube.com/watch?v=3xEfhSFsOW4&t=60s”\s
                    """);
        }
    }
