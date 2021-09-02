package com.example.ecotour.utilidades;

import java.util.HashMap;

public interface Utilidades
{

    Integer[][] billeteraPresupuesto = {
            {15000,1},
            {10000,2},
            {25000,3},
            {30000,4},
            {35000,5},
            {40000,6},
            {45000,7},
            {50000,8},
            {55000,9},
            {60000,10},
            {10000,11},
            {15000,12},
            {20000,13},
            {25000,14},
            {30000,15},
            {35000,16},
            {40000,17},
            {45000,18},
            {50000,19},
            {55000,20}
    };

    String[] NOMBRE_PARQUES = {"Parque Nacional Natural Gorgona",
            "Santuario de Flora y Fauna Malpelo",
            "Santuario de Flora y Fauna Iguaque",
            "Parque Nacional Natural Tayrona",
            "Parque Nacional Natural Sierra Nevada de Santa Marta",
            "Parque Nacional Natural Farallones de Cali",
            "Parque Nacional Natural Puracé",
            "Parque Nacional Natural El Tuparro",
            "Parque Nacional Natural los Katios",
            "Parque Nacional Natural Nevado del Huila",
            "Parque Nacional Natural Sumapaz",
            "Santuario Fauna y Flora los flamencos",
            "Área natural única los Estoraques",
            "Parque Nacional Natural Bahía Portete",
            "Parque Nacional Natural Chingaza",
            "Parque Nacional Natural Amacayacu",
            "Parque Nacional Natural Pisba",
            "Parque Nacional Natural Sanquianga",
            "Parque Nacional Natural Macuira",
            "Parque Nacional Natural La Paya"};

    String[] IMAGENES = {"pnn_gorgona", "sff_malpelo", "sff_iguaque",
            "pnn_tayrona", "pnn_sierra_nevada", "pnn_farallones", "pnn_purace", "pnn_el_tuparro",
            "pnn_katios", "pnn_nevado_del_huila", "pnn_sumapaz", "sff_los_flamencos",
            "anu_los_estoraques", "pnn_bahia_portete", "pnn_chingaza", "pnn_amacayacu", "pnn_pisba",
            "pnn_sanquianga", "pnn_macuira", "pnn_la_paya"};

    String[] UBICACIONES_GEOGRAFICAS = {"Pacífico colombiano", "Pacífico colombiano",
            "Tunja Boyacá", "Magdalena", "Magdalena", "Cali", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] CALIFICACIONES = {"4.85", "4.94", "4.64", "4.53", "4.85 ", "4.55", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] CANTIDAD_CALIFICACIONES = {"94", "2345", "1665", "1835", "2895", "3345", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] DESCRIPCIONES = {"P.N.N. Isla Gorgona forma parte de una de las 59 áreas protegidas del sistema de PNN de" +
            "Colombia. El parque está conformado por dos islas (Gorgona y Gorgonilla).La isla es de" +
            "vital importancia ya que forma parte del “Corredor Marino del Pacífico Este Tropical”, junto" +
            "con SFF Malpelo, PN Galápagos (Ecuador), Los Cocos (Costa Rica) y Coiba (Panamá).",
            //Parque 2
            "La Isla de Malpelo, alberga las más importantes formaciones coralinas del Pacífico" +
                    "colombiano, junto a gran cantidad de animales marinos asociados, la naturaleza volcánica" +
                    "del archipiélago y ciertos procesos erosivos han creado paisajes submarinos" +
                    "espectaculares, donde se pueden realizar actividades de buceo recreativo y educativo por" +
                    "los alrededores del Santuario.",
            //Parque 3
            "La laguna de Iguaque es uno de los centros mitícos del mundo. De esta se desprende la" +
                    "leyenda de Bachué \"Mujer Buena\" diosa madre de los Muiscas.Este santuario fue" +
                    "consagrado a los antiguos dioses Muiscas y no es nada raro que en sus lagunas se" +
                    "realizarán ceremonias con ofrendas de oro para los dioses Sué y Chía. Peregrinar a estas" +
                    "lagunas sagradas, limpia el alma y purifica el espíritu.",
            //Parque 4
            "Las estribaciones de la Sierra Nevada de Santa Marta, la montaña costera más alta del" +
                    "mundo se hunden en el mar como los dedos de una mano gigantesca entre los que se" +
                    "forman bahías y ensenadas de belleza singular: Chengue, Gayraca, Cinto, Neguanje," +
                    "Concha, Guachaquita, con sus playas de arenas blancas delimitadas por, manglares," +
                    "matorrales o bosques, y bañadas todas por las aguas azules y cristalinas del mar Caribe," +
                    "hacen parte de los muchos atractivos queofrece el Parque Nacional Natural Tayrona.",
            //Parque 5
            "La Sierra es la cuna de los Tayrona, la más monumental y singular civilización indígena del" +
                    "país.Allí viven alrededor de 30,000 indígenas de las etnias Kogui, Arhuaco, Kankuamo y" +
                    "Wiwa(Arsarios). Es la montaña más alta del mundo a orillas del mar y tiene las dos" +
                    "montañas más altas de Colombia, los picos Colón y Bolívar. Dentro de este macizo" +
                    "montañoso se encuentraubicado el Parque Arqueológico Teyuna “Ciudad Perdida” a cargo" +
                    "del Instituto Colombiano de Antropología e Historia.",
            //Parque 6
            "Desde el valle del Cauca, en días sin nubes, mirando hacia el poniente se aprecian los" +
                    "afiladospicos azules de los Farallones de Cali, que se levantan casi verticalmente sobre la" +
                    "llanura separando las cuencas del Pacífico y del río Cauca.Actualmente en el Parque habita" +
                    "un grupo pequeño de indígenas Cholos del grupo Chocó (Emberas), quienes ocupan las" +
                    "partes bajas de los ríos que desembocan en el Pacífico. Animales y plantas se refugian en" +
                    "las densas selvas de aquellas montañas",
            //Parque 7
            "La zona es una cadena volcánica con numerosas fuentes azufradas, innumerables lagunas," +
                    "páramos y bosques de niebla. Los ríos más importantes de la patria nacen aquí: el" +
                    "Magdalena, el Cauca, el Caquetá, además existen más de 50 lagunas a lo largo de sus" +
                    "valles de origen glacial.",
            //Parque 8
            "Podría describirse como una extensa sabana verde surcada por grandes ríos con potentes" +
                    "raudales y playas doradas, pequeños caños de aguas cristalinas, bosques de galería," +
                    "morichales y saladillales, además de enormes rocas cristalinas en forma de cerros" +
                    "redondeados.",
            //Parque 9
            "Lo surcan el Atrato uno de los ríos más caudalosos del mundo. En este Parque se mezclan" +
                    "organismos típicos de las selvas húmedas del Chocó biogeográfico con elementos de" +
                    "afinidad caribeña propios de los bosques secos.",
            //Parque 10
            "El macizo del Nevado del Huila es una de las mayores reservas hidrográficas del sur de" +
                    "país. Es considerada estratégica ya que abastece las dos cuencas mas importantes del país" +
                    "(Cuenca alta del Río Magdalena y Cuenca alta del Río Cauca) catalogando como una" +
                    "estrella hídrica del macizo colombiano, que aporta bienes y servicios ambientales.",
            //Parque 11
            "Sumapaz es uno de los principales ecosistemas de páramos que existen en el país, su" +
                    "innegable importancia radica no solo en su atractivo paisajístico, sino porque además éste" +
                    "es uno de los pocos espacios en donde habitan especies únicas de flora y fauna, que por" +
                    "las condiciones del clima tan solo viven a estas alturas. Aquí se encuentra la mayor reserva" +
                    "biótica en los Andes Colombianos y es una de las mayores reservas hídricas de la patria",
            //Parque 12
            "La quietud de los cielos azules y despejados de la península de la Guajira, zona desértica" +
                    "del nororiente colombiano, se ve interrumpida por arreboles de un rosado intenso que se" +
                    "disuelven en espirales sobre las lagunas del Santuario, se trata de bandadas de flamencos," +
                    "aves altas y esbeltas, cuyo plumaje rosado fue, para los egipcios, la definición del color rojo.",
            //Parque 13
            "Los Estoraques, son grandes y bellas esculturas naturales labradas por el agua y el viento y" +
                    "endurecidas por el sol. Conforman columnas y torres, colinas y crestas montañosas y" +
                    "grandes cárcavas que mueren en grandes valles aluviales salpicados de matorrales que" +
                    "tienen gran afinidad con los matorrales de la costa del Caribe y de algunos valles secos" +
                    "interandinos.",
            //Parque 14
            "En el Parque Nacional Natural Bahía Portete – Kaurrele están presentes ecosistemas" +
                    "marinos y costeros estratégicos para la supervivencia y desarrollo de las diferentes fases" +
                    "del ciclo de vida muy importantes como fondos sedimentarios, praderas de pastos marinos," +
                    "formaciones coralinas, manglares, playas y litoral rocoso.",
            //Parque 15
            "El Parque Natural Chingaza que se desprende de un ramal del páramo de Guasca, es una" +
                    "gran cadena montañosa que nutre con sus aguas a dos grandes cuencas hidrográficas, la" +
                    "del río Negro y la del río Guavio. En este bello parque se encuentran algunos de los" +
                    "endemismos de la flora.",
            //Parque 16
            "El Parque Amacayacu abarca un paisaje selvático plano de la cuenca sedimentaria del río" +
                    "Amazonas. Se estima que en el parque viven 150 especies de mamíferos y entre estos se" +
                    "destaca el delfín rosado del Amazonas, especie única en el mundo y de gran belleza." +
                    "Especies como el cedro rojo y blanco, el caoba, la ceiba y el uvo son de los árboles más" +
                    "altos e impresionantes que encontramos en el parque.",
            //Parque 17
            "El Parque Nacional Natural de Pisba, comprende un sistema de escarpadas montañas de la" +
                    "cordillera Oriental. La vertiente oriental es muy húmeda, ya que sobre este lado se localizan" +
                    "las selvas húmedas del piedemonte llanero que se incrustan en la orinoquía. La vertiente" +
                    "del lado occidental es muy seca y limita con el río Chicamocha.",
            //Parque 18
            "El Parque Natural Sanquianga abarca un ambiente de deltas donde dominan las" +
                    "condiciones anfibias que alternan períodos de inundación y de emersión de tierras, según la" +
                    "acción de las mareas y los ríos.",
            //Parque 19
            "La Serranía de la Macuira es un oasis de bosques de montaña que se levanta sobre las" +
                    "tierras bajas del cinturón árido precaribeño en la Alta Guajira. Sus flancos montañosos que" +
                    "llevan dirección noroeste - suroeste comprenden también cerros aislados, de gran belleza y" +
                    "mucha biodiversidad.o con elementos de afinidad caribeña propios de los bosques secos." +
                    "Poblaci",
            //Parque 20
            "En medio de la selva tropical del bajo Putumayo, una de las regiones más ricas del país," +
                    "está el Parque Nacional La Paya, una inmensa extensión de selvas e intrincados ríos que" +
                    "albergan grandes cantidades de especies tanto de flora como de fauna y es el lugar de" +
                    "habitación de no menos de diez grupos indígenas."};

    String[] POBLACIONES_CERCANAS = {"Guapi, la Vigía, Mulatos y Buenaventura",
            "Puerto de Buenaventura.", "Tunja, Villa de Leyva, Arcabuco, Chiquinquirá.",
            "Santa Marta, Calabazo, Palomino.", "Riohacha, Maicao, Uribia, Nazareth, Siapana.",
            "Cali, Jamundí, Pance, Pichindé, Peñas Blancas.", "Puracé, Coconucos, Popayán, San José de lsnos.",
            "Puerto Carreño, El Tapón, El Burro - Puerto Ayacucho (Venezuela)",
            "Turbo, Ungia Y Puente América", "lnzá (llamada también Páez), Toez, La Plata, Santander de Quilichao, Mosoco, Silvia",
            "Usme, Nazareth, San Juan de Sumapaz, Bogotá", "Riohacha, Camarones, Dibulla.",
            "Cúcuta, Ocaña, la Playa", "El Cabo de la Vela y Uribia, la capital de los wayuús, son los mas cercanos. Luego siguen" +
            "Manaure y Riohacha", "Bogotá, La Calera, Fómeque, Guasca.", "Leticia, Mocagua, San Martín, Puerto Nariño.",
            "Sogamoso, Corrales, Yopal, Pisba, Socha, Los Pinos.", "La Vigía (Nariño), Guapi (Cauca).",
            "Noreste de la Península de la Guajira, municipio de Uribía.", "La Nueva Paya, Puerto Leguízamo, Salado Chico, El Recreo, El Porvenir, San Isidro, El" +
            "Palmar, Puerto Cecilia, La Tagua, Puerto Ospina y Monclart."};

    String[] FLORA_FAUNA = {"Se registran 46 especies de gusanos marinos, 466 especies de moluscos marinos, 70" +
            "especies de crustáceos braquiurus, 75 de macrurus y anomurus y 5 especies de crustáceos" +
            "de agua dulce. También se encuentran 427 especies de toplancton representadas en su" +
            "mayoría por diatomeas y dinofalgelados y 96 familias de zooplancton, siendo los copépodos" +
            "los organismos de mayor abundancia",
            //Parque 2
            "Entre los animales marinos están las estrellas de mar (dos endémicas), peces ángel," +
                    "morenas, mantarrayas, tiburones ballena y escuelas de tiburón martillo.Los tres reptiles" +
                    "endémicos terrestres de la isla son: Anolis agassizi, Diploglossus millepunctatus y" +
                    "Phyllodactus traversalis. Una gran población de aves marinas habitan la isla, compuesta" +
                    "principalmente por una población de Piqueros enmascarado Sula granti.",
            //Parque 3
            "Las especies animales del Santuario pertenecen a la fauna andina y fauna de páramo. Se" +
                    "puede encontrar fauna silvestre como faras, murciélagos frugívoros, ardillas, armadillos," +
                    "conejos silvestres, curíes,borugos, zorros y venados. Entre las aves se destacan alondras," +
                    "perdices, pavas, tucanes verdes, tangaras, patos, colibríes, clarineros.En los bosques, las" +
                    "principales especies vegetales son roble, frailejón, gaque, siete cueros, canelón, tobo," +
                    "líquenes, quiches, orquídeas y helechos. En el páramo sobresalen los frailejones," +
                    "lospajonales y el mortiño.",
            //Parque 4
            "Los bosques secos del parque presentan entre la mitad y un tercio de las plantas, en " +
                    "comparación con los bosques húmedos. Aquí sobresalen especies como la ceiba (Hura " +
                    "crepitans), el trupillo (Prosopis julliora), el aromo (Acaciatortuosa), el brasil (Haematoxylon " +
                    "brasiletto), el dividivi (Caesalpinia coriaria), el guamacho (Pereskia guamacho). ",
            //Parque 5
            "De acuerdo con apreciaciones de especialistas, la diversidad orística de la Sierra Nevada " +
                    "de Santa Marta, es considerada baja, especialmente en las selvas húmedas del arco " +
                    "septentrional. Se da un número de 1.800 especies de plantas en la Sierra Nevada que se " +
                    "agrupan en 636 géneros y 164 familias.",
            //Parque 6
            "Los Farallones están habitados por varias especies de mamíferos, desde pequeños "+
                    "murciélagos hasta pumas, panteras,tigrillos, zorros y osos de anteojos. Sobresalen también " +
                    "los marsupiales; cinco especies de primates (mico maicero, monocolorado, chongo, marteja " +
                    "o mico de noche",
            //Parque 7
            "De la fauna del Parque se cuenta con mayor información sobre el grupo de los vertebrados. " +
                    "Las aves se destacan como el grupo más representativo. Predominan los colibríes, patos, " +
                    "azulejos y rapaces. Del grupo de mamíferos se destacan el oso andino o de anteojos, el " +
                    "venado conejo, el venado soche o colorado, la danta o tapir de páramo, el tigrillo y el puma. ",
            //Parque 8
            "Los bosques del parque son de dos tipos, los ripiarios o de galería, que son los que siguen " +
                    "los cursos de los ríos y caños, algunos de los cuales son inundables o de rebalse, mientras " +
                    "que otros no se inundan. También están los no ripiarios. En la mayoría de las cabeceras de" +
                    "los caños se presentan dos comunidades arbóreas muy típicas: el morichal y el saladillal." +
                    "Existen otros tipos de vegetación, como el de las sabanas de pastos, las zonas con" +
                    "propensión a incendios, los médanos y los pantanos arbolados",
            //Parque 9
            "La vegetación herbácea y flotante de ciénagas y pantanos, sobresalen la palma conocida" +
                    "como pangana, resistente a las inundaciones, la jacaranda, la palma mil pesos y el cativo." +
                    "En zonas secas también se encuentran especies como el canime, roble, nazareno, caracolí," +
                    "olleto, sande y güino. Entre esta gran diversidad de fauna, las especies más representativas" +
                    "son: Dantas, manatíes, zorros, perros de monte, jaguares, pumas, osos andinos, monos" +
                    "aulladores, marimondas, titíes, paujiles, águilas, reptiles, anfibios, invertebrados, peces" +
                    "como el bocachico, la doncella, guacuco, bagre de río y la cachana como especie en peligro" +
                    "y otras especies como rayas de río.",
            //Parque 10
            "En fauna se destacan especies como el venado conejo, el oso de anteojos, la dánta de" +
                    "páramo y el tigrillo así como mucha fauna endémica y vulnerable de los ecosistemas" +
                    "altoandinos. Dentro de las especies forestales más relevantes en el área se destacan el" +
                    "pino colombiano (Podocarpus rospigliosii), (Retrophylum rospigliosii), el cedro (Cedrela" +
                    "montana), el comino (Aniba perutilis) y el coralito de páramo (Relbunium hypocarpium).",
            //Parque 11
            "Dentro de los rasgos florísticos del páramo se encuentran comunidades cerradas con" +
                    "matorrales de Asteraceae y bosques achaparrados con Polylepis, formaciones abiertas con" +
                    "Espeletia y pajonales con Calamagrostis. Adicionalmente pastizales, prados, turberas," +
                    "chuscales y tremedales. Las especies dominantes del estrato superior son arenillo," +
                    "caracaro, carne de vaca, amarillo, anime, aceite maría, cachicamo, y canelo. Las principales" +
                    "especies que componen el segundo estrato son diomate, canelo, solera, guacamayo y" +
                    "guayacán, estas especies son las que ocupan el reglón de vegetación arbórea secundaria." +
                    "Las principales especies del tercer estrato son siete cueros, encenillo, guino, lacre, granizo," +
                    "laurel, yarumo, balso y blanquillo.",
            //Parque 12
            "En el Santuario existe una rica variedad de fauna entre la que podemos resaltar zainos," +
                    "osos hormigueros, venados, tigrillos, zorros y una extensa variedad de aves estuarinas y" +
                    "continentales, entre las que sobresalen el flamenco y el rey guajiro. En el sector donde se" +
                    "encuentra cobertura vegetal de tipo manglar se pueden encontrar mamíferos de poca" +
                    "movilidad como roedores, carnívoros, marsupiales y primates; donde prevalece la" +
                    "vegetación seca se puede encontrar roedores, marsupiales y algunos carnívoros como el" +
                    "zorro chucho y la comadreja.",
            //Parque 13
            "Los árboles más comunes son en el área protegida son el “mantequillo”, el “arrayán”, el" +
                    "“rampacho o raque”, el “mapurito”, el “loqueto”, y los “encenillos”. Dentro de las especies" +
                    "arbustivas se encuentran el “peralejo”, el “chaparro”, el “guayabo, el “chirca o chilco”, el" +
                    "“papamo”, el “uvito negro”, el “clavelillo” y la especie endémica Calyptranthes estoraquensis",
            //Parque 14
            "Manglares, corales, aves, langostas, camarones, gran variedad de moluscos, almejas, " +
                    "caracoles, ostras, peces como el mero, róbalo, pargo, lisa, lebranche, sierra, sardina, " +
                    "reptiles, tortugas, erizos, armadillos, murciélagos, zorros, zainos entre otros, son algunas de " +
                    "las especies de la rica biodiversidad de esta región, que quedaron protegidas con la" +
                    "declaratoria de este nuevo parque natural",
            //Parque 15
            "El Parque cuenta con una variedad importante de especies vegetales. Existen ocho" +
                    "especies de Sphagnum o musgo de pantano, que son maravillas ecológicas en cuanto a la" +
                    "conservación de la humedad ambiental pues pueden absorber hasta 40 veces su peso de" +
                    "agua.",
            //Parque 16
            "El Parque Amacayacu posee más de 468 especies de aves, entre las que sobresalen los" +
                    "crácidos (pavas o paujiles) como la “Pava Hedionda” y las tinamidas o gallinetas de gran" +
                    "significancia para las comunidades locales por lo que representan tanto en la dieta" +
                    "alimenticia como en su tradición cultural. De igual forma sobresalen los piuris, los “Paujiles" +
                    "de Altura” (Mitu mitu tuberosa) y los tentes. Se encuentran once especies de garzas y" +
                    "garzones que conforman el principal grupo presente en las áreas acuáticas y sobresale el" +
                    "grupo de las psitácidas como las guacamayas (seis especies) como la “Guacamayita" +
                    "morichalera”, ligada a la palma de aguaje o moriche y los loros.",
            //Parque 17
            "En cuanto a fauna se pueden distinguir mamíferos grandes como puma, tigrillo, oso de" +
                    "anteojos, venados, entre otros. Así mismo la avifauna es un grupo que se encuentra bien" +
                    "representado, sobre todo en áreas lacustres del Parque con varias especies de patos y el" +
                    "cucarachero de pantano. La biodiversidad en las zonas de paramos esta representada por" +
                    "especies de frailejones entre los que se pueden mencionar Espeletia jaramilliana, Espeletia" +
                    "ariana, Espeletia boyacensis, Espeletia brassicoidea, Espeletia cleefii, Espeletia" +
                    "congestiflora, entre otras. Además podemos encontrar pequeñas manchas boscosas de" +
                    "Polylepis quadrijuga.",
            //Parque 18
            "El Parque registra una altísima presencia de recursos hidrobiológicos, según el SIPEIN se le" +
                    "hacen seguimiento a 186 especies de peces, entre otros: sierra, pargo, corvina, machetazo," +
                    "barbinche, lisa, gualajo y merlusa. Crustáceos: se reportan tres (3) especies de camarón:" +
                    "langostino, titi y tigre, pero hay muchas más; langostas, cangrejos, jaibas, maricacos y",
            //Parque 19
            "La flora del parque incluye 350 especies, de las cuales en el bosque nublado se encuentran " +
                    "20 plantas inferiores, incluyendo helechos arborescentes y un helecho epifito y nueve" +
                    "bromelias epifitas, todas con facilidad de almacenar agua. El flanco nordeste entre 50 y 400" +
                    "metros tiene un bosque caducifolio con especies como resbala mono o indio desnudo. A lo" +
                    "largo de los arroyos se encuentran franjas de bosque de galería con especies como el" +
                    "caracolí. Hasta los 200 metros de altitud se encuentran bosques, típicos de la planicie" +
                    "guajira.",
            //Parque 20
            "Las especies vegetales que se consideran más importantes son: el palmito (Euterpe " +
                    "oleracea), el asaí (Euterpe precatoria), canagucha (Mauritia flexuosa), chambira " +
                    "(Astrocaryum chambira), milpesos (Oenocarpus bataua), la uva caimarona (Maclenia " +
                    "rupestris), la macoubea (Macouvea guianensis), el icaco (Chrysobalanus icaco), la platonia " +
                    "(Platonia insignes), el noli (Elaeis oleifera) y el arazá (Eugenia stipitata), el cedro (Cedrela " +
                    "sp.) y el granadillo (Platymiscium sculatum), ceiba (Ceiba pentandra), Hachapo " +
                    "(Pithecellobium)."};

    String TITULO_COMO_LLEGAR = "Transporte";
    String TITULO_RECOMENDACIONES = "Recomendaciones";
    String[] RECOMENDACIONES = {"Vacunarse contra fiebre amarilla y tétano, llevar botiquín de primeros auxilios que incluya " +
            "suero antiofídico polivalente, medicamento contra diarrea y amebas.No se permite la " +
            "entrada de materiales no biodegradables, así como tampoco la entrada de bebidas " +
            "alcohólicas. Ropa fresca de algodón, botas, equipo básico de buceo, protector solar, " +
            "binóculos, linterna.",
            //Parque 2
            "Para bucear en Malpelo se debe contar con buzo líder, debidamente certificado, que " +
                    "conozca la zona, liderando un grupo de no más de seis buzos. Las personas practicantes " +
                    "deberán contar con un nivel de certificación de buzo avanzado o dos estrellas, y con un " +
                    "mínimo de 25 buceos en bitácora.",
            //Parque 3
            "Llevar equipo de campamento adecuado para clima frío. Ropa abrigada y botiquín de " +
                    "primeros auxilios. Y no olvide no deje basura y no contamine los arrollos ni las laguna",
            //Parque 4
            "Vacunarse contra fiebre amarilla y tétano. Llevar ropa adecuada para clima cálido, protector " +
                    "solar.Tener cuidado en el mar, pues presenta fuertes oleadas y peligrosas corrientes " +
                    "submarinas. En algunas zonas nadar puede ser peligroso. No tome riesgos innecesarios. " +
                    "En algunas zonas nadar puede ser peligroso. No tome riesgos innecesarios.",
            //Parque 5
            "Vacunarse contra el tétano y llevar botiquín de primeros auxilios que incluya suero antiodico " +
                    "y antidiarreicos. Se debe contar siempre con un guía y con equipo completo de alta " +
                    "montaña, en caso de ir a las lagunas y nieves perpetuas o hamaca, toldillo o saco de dormir " +
                    "o frazadas en caso de ir a la Cuidad Perdida. Es conveniente usar camisas de manga larga " +
                    "y pantalones gruesos.",
            //Parque 6
            "Llevar todos los alimentos necesarios. Botiquín de primeros auxilios, repelente contra " +
                    "insectos, ropa adecuada para la región que se va a visitar (tierras bajas o alta montaña), " +
                    "elementos necesarios para acampar, linterna, pilas y cámara fotográca.Desde los " +
                    "paramillos, en días excepcionalmente despejados, se aprecia el Océano Pacíco hacia el " +
                    "oeste, y el valle del Cauca y la cordillera Central hacia el este. Y no olvide no deje basura y " +
                    "no contamine las fuentes de agua así como no destruya la naturaleza.",
            //Parque 7
            "Para ascender a los picos debe llevarse el equipo apropiado: chaqueta de material " +
                    "impermeable que permita la transpiración y de aislante térmico, pasamontañas, guantes, " +
                    "pantalones impermeables, polainas y botas para alta montaña.",
            //Parque 8
            "Vacunarse contra fiebre amarilla y tétano, y llevar completo equipo de primeros auxilios y " +
                    "suero antiofídico. Además llevar botas, ropa de algodón, camisas de manga larga, " +
                    "impermeable, linterna, sombrero, protector solar, repelente contra insectos, vestido de baño " +
                    "y cámara fotográfica.",
            //Parque 9
            "Son imprescindibles los toldillos. Evitar el transito por el río o el bosque después de la seis " +
                    "de la tarde. Llevar botiquín de primeros auxilios con suero antiofídico y medicamentos para " +
                    "controlar reacciones alérgicas (picaduras de avispas etc.)",
            //Parque 10
            "Hacer paradas de aclimatación durante el viaje. En los glaciares deben usarse lentes " +
                    "oscuros, que filtren la radiación reflejada por la nieve. Es importante llevar ropa extra y no " +
                    "usarla durante las caminatas. No correr, evitar agitarse excesivamente, no fumar.",
            //Parque 11
            "Hacer paradas de aclimatación durante el viaje. Es importante llevar ropa extra y no usarla " +
                    "durante las caminatas. No correr, evitar agitarse excesivamente, no fumar.",
            //Parque 12
            "Llevar líquidos para las caminatas largas, alimentos con bastantes calorías, botas, pantalón " +
                    "largo, camisa de manga larga y ante todo no dejar basura y no dañar la vegetación nativa ni " +
                    "extraer plantas ya que esto afecta en gran manera el ecosistema del lugar",
            //Parque 13
            "Protegerse del sol y eventualmente, abrigarse un poco. No hacer grafitis en los Estoraques " +
                    "ni tallarlos. Y recuerde no contamine las fuentes de agua, respete el entorno natural y no " +
                    "deje basura.",
            //Parque 14
            "Llevar abundante provisión de agua dulce. Para acampar debe llevarse el equipo apropiado. " +
                    "Llevar botiquín de primeros auxilios que incluya suero antiofídico polivalente, y antidiarreico. " +
                    "Además llevar ropa de algodón, camisas de manga larga, impermeable, linterna, sombrero, " +
                    "protector solar, repelente contra insectos. Y no olvide no deje basura y no contamine las " +
                    "fuentes de agua así como no destruya la naturaleza.",
            //Parque 15
            "Llevar botas plásticas, bloqueador, ropa adecuada para el frío e impermeable. Toda la " +
                    "basura que se genere debe sacarse del Parque (traer bolsas de basura). No arrojar ningún " +
                    "tipo de residuo orgánico e inorgánico en las vías de acceso al área protegida. Los puestos " +
                    "de salud más cercanos están en los municipios de La Calera para Piedras Gordas y Guasca    " +
                    "para Siecha. No fumar.",
            //Parque 16
            "Vacunarse contra fiebre amarilla y tétano, llevar botiquín de primeros auxilios que incluya " +
                    "suero antiofídico polivalente, y antidiarreico. Además llevar botas de caucho, ropa de " +
                    "algodón, camisas de manga larga, impermeable, ¡interna, sombrero, protector solar, " +
                    "repelente contra insectos.",
            //Parque 17
            "Vacunarse contra tétano, llevar botiquín de primeros auxilios y ropa abrigada. Si se planea " +
                    "acampar debe llevarse todo el equipo y las provisiones. No olvide capas y botas " +
                    "Impermeables. No destruya la naturaleza ya que existen especies endemicas y olvide no " +
                    "contamine los riachuelos ni las lagunas, no deje basura.",
            //Parque 18
            "Vacunarse contra tétano, llevar botiquín de primeros auxilios y agua potable. Ropa fresca de " +
                    "algodón, preferiblemente de manga larga. Traje de baño, impermeable, sombrero, botas, " +
                    "cámara fotográfica, binóculos, linterna y pilas. Debe solicitarse el permiso con suficiente " +
                    "tiempo a la División de Parques del Ministerio del Medio Ambiente.",
            //Parque 19
            "Vacunarse contra el tétano y llevar botiquín de primeros auxilios, que incluyan " +
                    "medicamentos contra las garrapatas. Usar protector solar, sombrero y ropa apropiada para " +
                    "el clima seco y caliente así como cantimplora.",
            //Parque 20
            "Vacunarse contra fiebre amarilla y tétano; llevar botiquín de primeros auxilios que incluya " +
                    "suero antiofídico polivalente, antidiarreico y medicamentos contra amebiasis. Además llevar " +
                    "botas de caucho, ropa de algodón, camisas de manga larga, impermeable, linterna, " +
                    "sombrero, protector solar, repelente contra insectos, toldillo, y saco de dormir o hamaca.",};

    String[][] NOMBRES_RUTAS = {
            {"Vía aérea Cali – Guapi", "Ruta Guapi - Gorgona"},
            {"Transporte marítimo"},
            {"Transporte"},
            {"Transporte"},
            {"Transporte"},
            {"Transporte"},
            {""},// 7
            {""},// 8
            {""},
            {""},
            {""},
            {""},
            {""},
            {""},
            {""},
            {""},
            {""},
            {""},
            {""},
            {""},
    };

    String[][] RUTAS = {
            //Parque 1
            {"Todos los días sale un vuelo de la ciudad de Cali hacia el municipio de Guapi por la " +
                    "aerolínea Satena. Este vuelo tiene una duración de 45 minutos y parte generalmente a las " +
                    "9:50 am, este horario puede verse afectado por las condiciones climáticas del día.",
            "Una Lancha rápida sale todos los lunes, miércoles y viernes a las 12:30 pm desde el muelle " +
                    "turístico de Guapi, es un recorrido que dura 1 hora 30 minutos hasta llegar a Gorgona. Es " +
                    "necesario reservar este servicio con anterioridad y es manejado directamente por la " +
                    "concesión."},
            //Parque 2
            {"La única forma de acceder a la isla es a través de transporte marítimo con un aproximado " +
                    "de 36 horas de navegación en mar abierto, saliendo desde Buenaventura.En el momento " +
                    "tres operadores turísticos privados cuentan con el permiso de ingreso al Santuario y brindan " +
                    "el recorrido únicamente durante fechas estipuladas, por lo que se le sugiere al turista " +
                    "preparar con antelación la visita y consultar calendario de ingreso de las " +
                    "embarcaciones.Desde Buenaventura en barco durante 36 horas hasta el SFF Malpelo y " +
                    "desde puertos en Costa Rica y Panamá, hasta el SFF Malpelo."},
            //Parque 3
            {"Para llegar a la Laguna de Iguaque desde la ciudad de Bogotá primero tomamos un bus " +
                    "hasta el municipio de Villa de Leyva y desde allí en la terminal de transportes encontramos " +
                    "un bus que nos dejará muy cerca de la entrada de la Laguna de Iguaque (no hay un " +
                    "transporte que vaya hasta la entrada por el mal estado de la carretera) deben decirle al " +
                    "conductor que los deje en el sector conocido como Casa de Piedra.El bus que los deja en " +
                    "Casa de Piedra sale desde las 5:00 am hasta las 7:00 am, a las 8:00 am solo encuentran un " +
                    "bus que los deja en un sector conocido como Los Pinos,lo que supone una caminata extra"},
            //Parque 4
            {"Al Parque Tayrona puedes llegar desde Santa Marta, ciudad a la que puedes llegar en " +
                    "carro, avión o en bus. Las principales rutas y tarifas son:\n" +
                    "– Bus Bogotá a Santa Marta: 19 horas y $150.000 COP\n" +
                    "– Bus Barranquilla a Santa Marta: 1 hora y $30.000 COP\n" +
                    "– Bus Cartagena a Santa Marta: 4 horas y $30.000 COP\n" +
                    "– Bus Medellín a Santa Marta: 16 horas y $180.000 COP\n" +
                    "Público o la Terminal de transportes de Santa Marta, puedes tomar un bus hasta una de las\n" +
                    "tres entradas del Parque Tayrona. El recorrido es en promedio de 45 minutos y el bus por\n" +
                    "dejarte en cualquier entrada te cobrará menos de $10.000 COP."},
            //Parque 5
            {"Para llegar desde Santa Marta, se toma una carretera de aproximadamente 42 Km por la " +
                    "vía que conduce al corregimiento de Minca, a la vereda El Campano y luego a la vereda " +
                    "Bellavista, donde se gira hacia dicha Estación. Los primeros 25 km están pavimentados y el " +
                    "resto requiere de campero con doble tracción."},
            //Parque 6
            {"Saliendo de Cali se llega fácilmente a tres zonas del parque:Al Centro de Educación " +
                    "Ambiental El Topacio, después de 40 minutos de recorrido; a Quebrada Honda, cerca del río " +
                    "Pance, también a 40 minutos, y al río Pichindé y a Peñas Blancas después de 50 minutos.A " +
                    "los paramillos se puede llegar después de 6 u 8 horas de camino muy escarpado."},
            //Parque 7
            {"Desde Popayán se toma la vía que pasa por el pueblo de Puracé y conduce a La Plata, " +
                    "hasta el sitio denominado el Cruce. A partir de ese punto se toma un desvío hasta las " +
                    "cabañas del sector de Pilimbalá. También puede seguirse la vía a La Plata sin tomar el " +
                    "desvío y detenerse en la laguna de San Rafael, en la zona de los termales de San Juan o " +
                    "en el sector de San Nicolás."},
            //Parque 8
            {"Desde Bogotá el recorrido terrestre es el siguiente: Bogotá a Villavicencio 112 km. y a " +
                    "Puerto López 85 km. Hasta Puerto López hay carretera pavimentada y de ahí en adelante " +
                    "por carreteras destapadas y trochas. Se sigue a Puerto Gaitán 110 km., Puente Arimena 69 " +
                    "km., Carimagua 30 km., Gaviotas 40 km., Tres Matas 30 km., Tibabisco o La Catorce 55 " +
                    "km., el Tapón 180 km., Cabaña de Línea Roja 190 km. y de ahí 100 kilómetros hasta el " +
                    "centro administrativo."},
            //Parque 9
            {"Puede llegarse a las ciudades de Turbo, Chigorodo y Apartado por vía aérea desde " +
                    "Medellín. Tomando como punto de partida a Turbo (Antioquia) se atraviesa el Golfo de " +
                    "Uraba y se remonta el Rió Atrato hasta el Centro Administrativo de Sautatá, separado 1.300 " +
                    "mts de la orilla del rió. Desde Quibdo (Choco) puede viajarse a Riosucio y luego por el Rió " +
                    "Atrato hasta el Centro Administrativo. Desde Ungia (Choco) por el camino veredal se llega a " +
                    "la cabaña de Peye después de cuatro horas."},
            //Parque 10
            {"Desde Santander de Quilichao se toma la carretera que pasa por El Palo, Tacueyó, cerro los " +
                    "Alpes y conduce al alto Páez, donde se encuentra la cabaña del Ministerio del Medio " +
                    "Ambiente. Desde Popayán puede tomarse la ruta Piendamó, Silvia, Mosoco, Toez y " +
                    "finalmente el trayecto al alto Páez."},
            //Parque 11
            {"Desde Bogotá por la carretera que pasa por Usme, siguiendo la vía a Nazareth y San Juan " +
                    "de Sumapaz se recorre parte del norte del parque. Desde la Laguna Cajones se puede " +
                    "tomar un desvío hacia el sur hasta el Pantano Andabobos"},
            //Parque 12
            {"Después de veinte minutos de viaje por la Troncal de Caribe, desde Riohacha en dirección " +
                    "Santa Marta, se llega al desvío que conduce después de un par de kilómetros, al caserío de " +
                    "Camarones. Desde allí se toma una trocha de tres kilómetros hacia el litoral hasta llegar a la " +
                    "Boca, donde se encuentra el centro administrativo del Ministerio del Medio Ambiente " +
                    "(División de Parque Naturales). En carro particular y en transporte público se puede llegar a " +
                    "la Boca."},
            //Parque 13
            {"Al área natural única se puede llegar desde Cúcuta, por la vía a Sardinata y de allí a la " +
                    "población de Ábrego, de donde debe seguirse la ruta a la Playa, municipio que se encuentra " +
                    "en las faldas del alto de las Liscas, pequeña serranía que conforma el área de los " +
                    "Estoraques. Desde Bucaramanga, en dirección norte hacia Ocaña para dirigirse luego a la " +
                    "población de Ábrego, que es la antesala de acceso a la Playa de Belén"},
            //Parque 14
            {"Cuatro Vías, que lleva a Uribia y Manaure. Y la que conduce a El Pájaro y Musichi que es " +
                    "más interesante, pero no ofrece buenas condiciones para el tránsito durante todo el año. La " +
                    "distancia aproximada entre Riohacha y Uribia es de 95 km; de Uribia hasta el propio " +
                    "desierto es de 22 km; del inicio del desierto hasta El Cabo es de 30 km, y hasta el Parque " +
                    "Eólico y Puerto Bolívar; casi 50 km. Antes de llegar a la Bahía por la vía de Mareywamana, " +
                    "se encuentra una fracción de desierto característico llamado \"Desierto de la auyama”."},
            //Parque 15
            {"La carretera que conduce al parque se toma dos kilómetros después de La Calera por la vía " +
                    "a Guasca. Desde este punto a 35 km., por la carretera que conduce al Reten de Piedras " +
                    "Gordas, se encuentra la entrada al parque y al sector de las Lagunas de Siecha, Fausto y " +
                    "Sur América. Por la ruta Fómeque - Chingaza, una carretera en regular estado conduce a la " +
                    "entrada del parque después de 84 km. En épocas de invierno se requiere vehículo de doble " +
                    "tracción."},
            //Parque 16
            {"Se debe llegar a Leticia, que cuenta con aeropuerto internacional y vuelos comerciales " +
                    "todos los días. Desde el puerto, tomando el río Amazonas aguas arriba, se llega a la " +
                    "quebrada Matamatá después de dos horas de viaje en lancha con motor fuera de borda " +
                    "(aproximadamente 60 km.). En este recorrido se pasa por las islas de Ronda, Los Micos y " +
                    "los caseríos de Santa Sofía y Zaragoza. A la zona norte del parque se puede llegar por " +
                    "hidroavión sobre el río Cotuhé. En verano se puede caminar durante cinco días por una " +
                    "trocha que sigue el río Amacayacu y la quebrada Cabimas."},
            //Parque 17
            {"Se debe llegar a Leticia, que cuenta con aeropuerto internacional y vuelos comerciales " +
                    "todos los días. Desde el puerto, tomando el río Amazonas aguas arriba, se llega a la " +
                    "quebrada Matamatá después de dos horas de viaje en lancha con motor fuera de borda " +
                    "(aproximadamente 60 km.). En este recorrido se pasa por las islas de Ronda, Los Micos y " +
                    "los caseríos de Santa Sofía y Zaragoza. A la zona norte del parque se puede llegar por " +
                    "hidroavión sobre el río Cotuhé. En verano se puede caminar durante cinco días por una " +
                    "trocha que sigue el río Amacayacu y la quebrada Cabimas."},
            //Parque 18
            {"Desde Buenaventura (Valle del Cauca) por vía marítima en barcos de cabotaje, el viaje " +
                    "hasta La Vigía (Nariño), toma unas 15 horas. Generalmente la hora de salida, tanto a la ida " +
                    "como al regreso de los barcos de cabotaje, es las 4:00 de la tarde. Desde Guapi (Cauca) el " +
                    "viaje en lancha hasta La Vigía toma dos horas aproximadamente. Hay compañías aéreas " +
                    "que hacen la ruta Cali-Guapi-Cali"},
            //Parque 19
            {"Desde Riohacha se toma la vía a Maicao y a la altura del desvío denominado \"cuatro vías\" " +
                    "la carretera que conduce a Uribia. A continuación se viaja hasta Puerto Portete. A partir de " +
                    "allí se toma una serie de trochas que llevan a Nazareth, ubicada en el piedemonte de la " +
                    "Serranía. El recorrido toma entre 6 y 8 horas en vehículo de doble tracción. En época de " +
                    "invierno el sistema de trochas se pone muy difícil de transitar"},
            //Parque 20
            {"Los límites del parque están muy cerca de los ríos Caquetá y Putumayo cerca a la frontera " +
                    "con Perú. Se debe llegar primero a Puerto Leguízamo de allí se toma una lancha a motor " +
                    "rumbo al oriente, el recorrido dura aproximadamente 2 horas."},
    };
}
