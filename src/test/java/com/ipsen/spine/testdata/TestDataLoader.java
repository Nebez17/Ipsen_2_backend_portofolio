package com.ipsen.spine.testdata;

import com.ipsen.spine.model.*;
import com.ipsen.spine.repository.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.ipsen.spine.model.Permission.*;
import static com.ipsen.spine.model.Role.*;

@Component
@RequiredArgsConstructor
@Profile("testdata")
public class TestDataLoader {
    private static final List<String> QUESTIONS = List.of(
            "Jurisprudentie",
            "Online Outreach",
            "Chat met Fier",
            "Meldingen overig",
            "Wetenschappelijke artikelen",
            "Krantenartikelen",
            "Bereikbaar via browser (clearweb)?",
            "Bereikbaar via app?",
            "Anderszins bereikbaar (bijv. Darkweb)",
            "Gerelateerd aan andere platforms?",
            "Actief op andere platforms?",
            "Aanbieder reclames? (bijv. Google, …)",
            "Opvallendheden reclames? (bijv. bieden producten aan, …)",
            "Formaat (bijv. aantal gebruikers/advertenties/etc.)",
            "Eigenaar",
            "Bestuurder(s)",
            "(Europese) Contactgegevens",
            "Waar wordt data gehost? (privacystatement/locatie servers)"
    );

    private static final Map<String, List<AnswerScore>> ANSWERS = Map.of(
            "Twitter", List.of(
                    new AnswerScore(3, "nvt, feit (seksuele uitbuiting, criminele uitbuiting, seksueel geweld), rol technologie (ronselen, controle, aanbod)"),
                    new AnswerScore(1, "Ja, 2023"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(1, "2022-2023, ronselen"),
                    new AnswerScore(1, "The British Journal of Social Work, 7-9-2023, Engels, https://academic.oup.com/bjsw/advance-article/doi/10.1093/bjsw/bcad201/7263182]"),
                    new AnswerScore(1, "NRC Handelsblad, 6-6-2023, Nederlands, https://www.nrc.nl/nieuws/2023/06/06/bescherm-jongeren-tegen-sociale-media-opgroeien-zonder-cyberstress-is-al-ingewikkeld-zat-a4166484]"),
                    new AnswerScore(0, "Ja, www.x.com"),
                    new AnswerScore(0, "Ja"),
                    new AnswerScore(0, "Onbekend"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Ja, Google"),
                    new AnswerScore(0, "Geen"),
                    new AnswerScore(0, "368 miljoen"),
                    new AnswerScore(0, "Elon Musk"),
                    new AnswerScore(0, "Elon Musk"),
                    new AnswerScore(0, "https://help.twitter.com/en/forms/dsa/report"),
                    new AnswerScore(0, "Verenigde Staten")
            ),
            "Facebook", List.of(
                    new AnswerScore(3, "nvt, feit (seksuele uitbuiting, criminele uitbuiting, seksueel geweld), rol technologie (ronselen, controle, aanbod)"),
                    new AnswerScore(3, "Ja, 2021, 2022 en 2023"),
                    new AnswerScore(1, "Ja, 2022"),
                    new AnswerScore(0, "nvt"),
                    new AnswerScore(1, "International Journal of Environmental Research and Public Health, 12-8-2022, Engels, https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9407706/ "),
                    new AnswerScore(1, "De Telegraaf, 30-6-2021, Nederlands, https://www.telegraaf.nl/financieel/702193461/sociale-media-grootste-gevaar-voor-seksuele-uitbuiting-van-kinderen "),
                    new AnswerScore(0, "Ja, www.facebook.com"),
                    new AnswerScore(0, "Ja"),
                    new AnswerScore(0, "Onbekend"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Ja, Google"),
                    new AnswerScore(0, "Geen"),
                    new AnswerScore(0, "3,05 miljard"),
                    new AnswerScore(0, "Mark Zuckerberg"),
                    new AnswerScore(0, "Mark Zuckerberg"),
                    new AnswerScore(0, "https://www.facebook.com/help/678741677600131"),
                    new AnswerScore(0, "Verenigde Staten")

            ),
            "Instagram", List.of(
                    new AnswerScore(2, "nvt, feit (seksuele uitbuiting, criminele uitbuiting, seksueel geweld), rol technologie (aanbod)"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(1, "Ja, 2020"),
                    new AnswerScore(0, "nvt"),
                    new AnswerScore(1, "Pediatrics, 1-11-2017, Engels, https://publications.aap.org/pediatrics/article/140/Supplement_2/S67/34168/Benefits-and-Costs-of-Social-Media-in-Adolescence"),
                    new AnswerScore(1, "NOS, 29-3-2022, Nederlands, https://stories.nos.nl/artikel/2423085-als-social-media-zo-slecht-is-moeten-we-er-dan-niet-mee-stoppen "),
                    new AnswerScore(0, "Ja, www.instagram.com"),
                    new AnswerScore(0, "Ja"),
                    new AnswerScore(0, "Onbekend"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Ja, Google"),
                    new AnswerScore(0, "Geen"),
                    new AnswerScore(0, "2,4 miljard"),
                    new AnswerScore(0, "Meta"),
                    new AnswerScore(0, "Meta"),
                    new AnswerScore(0, "support@instagram.com"),
                    new AnswerScore(0, "Verenigde Staten")
            ),
            "Snapchat", List.of(
                    new AnswerScore(2, "nvt, feit (seksuele uitbuiting), rol technologie (ronselen, controle]"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Nvt"),
                    new AnswerScore(1, "Telematics and Informatics Reports, 9-2023, Engels, https://www.sciencedirect.com/science/article/pii/S2772503023000476 "),
                    new AnswerScore(1, "Volkskrant, 31-7-2023, Nederlands, https://www.volkskrant.nl/columns-opinie/de-snap-kaart-van-snapchat-is-een-kaart-waarvan-staatsveiligheidsagenten-gaan-watertanden~baa4248d/ "),
                    new AnswerScore(0, "Ja, www.snapchat.com"),
                    new AnswerScore(0, "Ja"),
                    new AnswerScore(0, "Onbekend"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Ja, Google"),
                    new AnswerScore(0, "Geen"),
                    new AnswerScore(0, "475 miljoen"),
                    new AnswerScore(0, "Evan Spiegel"),
                    new AnswerScore(0, "Evan Spiegel"),
                    new AnswerScore(0, "https://help.snapchat.com/hc/en-us/requests/new"),
                    new AnswerScore(0, "Verenigde Staten")
            ),
            "Tiktok", List.of(
                    new AnswerScore(2, "nvt, feit (seksuele uitbuiting, seksueel geweld), rol technologie (aanbod]"),
                    new AnswerScore(1, "Ja, 2023"),
                    new AnswerScore(1, "Ja, 2022"),
                    new AnswerScore(0, "Nvt"),
                    new AnswerScore(1, "International Journal of Environmental Research and Public Health, 18-8-2021, Engels, https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8393543/"),
                    new AnswerScore(1, "Psychiatric Times, 22-3-2022, Engels, https://www.psychiatrictimes.com/view/tiktok-biggest-concerns-for-children-and-adolescents "),
                    new AnswerScore(0, "Ja, www.tiktok.com"),
                    new AnswerScore(0, "Ja"),
                    new AnswerScore(0, "Onbekend"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Ja, Google"),
                    new AnswerScore(0, "Geen"),
                    new AnswerScore(0, "900,7 miljoen"),
                    new AnswerScore(0, "Zhang Yiming"),
                    new AnswerScore(0, "Zhang Yiming"),
                    new AnswerScore(0, "https://www.tiktok.com/about/contact?lang=en"),
                    new AnswerScore(0, "China")
            ),
            "YouTube", List.of(
                    new AnswerScore(3, "nvt, feit (seksuele uitbuiting, criminele uitbuiting, seksueel geweld), rol technologie (ronselen, controle, aanbod]"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(1, "Ja, 2021"),
                    new AnswerScore(0, "Nvt"),
                    new AnswerScore(1, "Social Media + Society, 17-4-2020, Engels, https://journals.sagepub.com/doi/10.1177/2056305120909474"),
                    new AnswerScore(1, "PZC, 29-9-2023, Nederlands, https://www.pzc.nl/gent/leerlingen-staan-in-bloot-bovenlijf-op-zijn-youtube-kanaal-meer-details-bekend-over-grensoverschrijdend-gedrag-van-leerkracht-uit-destelbergen~a62f8454/"),
                    new AnswerScore(0, "Ja, www.youtube.com"),
                    new AnswerScore(0, "Ja"),
                    new AnswerScore(0, "Onbekend"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Ja, Google"),
                    new AnswerScore(0, "Geen"),
                    new AnswerScore(0, "2,7 miljard"),
                    new AnswerScore(0, "Google"),
                    new AnswerScore(0, "Google"),
                    new AnswerScore(0, "https://www.youtube.com/t/contact_us"),
                    new AnswerScore(0, "Verenigde Staten")
            ),
            "Whatsapp", List.of(
                    new AnswerScore(2, "nvt, rol technologie (aanbod]"),
                    new AnswerScore(2, "Ja, 2022 en 2023"),
                    new AnswerScore(1, "Ja, 2023"),
                    new AnswerScore(0, "Nvt"),
                    new AnswerScore(1, "Generation Smartphone, 2018, Duits, https://www.generationsmartphone.ch/_data/Generation-Smartphone-Projektbericht.pdf"),
                    new AnswerScore(1, "The Guardian, 1-10-2022, Engels, https://www.theguardian.com/technology/2022/oct/01/poisonous-how-whatsapp-is-exposing-uk-school-children-to-bullying-and-harmful-content"),
                    new AnswerScore(0, "Ja, www.whatsapp.com"),
                    new AnswerScore(0, "Ja"),
                    new AnswerScore(0, "Onbekend"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Ja, Google"),
                    new AnswerScore(0, "Geen"),
                    new AnswerScore(0, "2,7 miljard"),
                    new AnswerScore(0, "Meta"),
                    new AnswerScore(0, "Meta"),
                    new AnswerScore(0, "https://www.whatsapp.com/contact_us"),
                    new AnswerScore(0, "Verenigde Staten")
            ),
            "Wechat", List.of(
                    new AnswerScore(3, "nvt, feit (seksuele uitbuiting, criminele uitbuiting, seksueel geweld), rol technologie (ronselen, controle, aanbod]"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(1, "Ja, 2019"),
                    new AnswerScore(0, "Nvt"),
                    new AnswerScore(1, "BMC Geriatrics, 22-4-2022, Engels, https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9023108/"),
                    new AnswerScore(1, "RTL Nieuws, 3-3-2022, Nederlands, https://www.rtlnieuws.nl/tech/artikel/5292145/tiktok-invloed-jeugd-kinderen-jongeren"),
                    new AnswerScore(0, "Ja, www.wechat.com"),
                    new AnswerScore(0, "Ja"),
                    new AnswerScore(0, "Onbekend"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Ja, Google"),
                    new AnswerScore(0, "Geen"),
                    new AnswerScore(0, "1,33 miljard"),
                    new AnswerScore(0, "Tencent"),
                    new AnswerScore(0, "Tencent"),
                    new AnswerScore(0, "https://www.wechat.com/en/contact_us.html"),
                    new AnswerScore(0, "China")
            ),
            "Telegram", List.of(
                    new AnswerScore(1, "nvt, feit (seksuele uitbuiting, seksueel geweld)]"),
                    new AnswerScore(3, "Ja, 2021, 2022 en 2023"),
                    new AnswerScore(2, "Ja, 2022 en 2023"),
                    new AnswerScore(2, "2020 en 2021, ronselen"),
                    new AnswerScore(1, "Journal of Pediatric Nursing, 6-4-2023, Engels, https://www.pediatricnursing.org/article/S0882-5963(23)00072-6/fulltext"),
                    new AnswerScore(1, "Omroep Brabant, 27-1-2021, Nederlands, https://www.omroepbrabant.nl/nieuws/3332878/zo-jutten-jongeren-elkaar-via-telegram-op-om-te-rellen-we-gaan-popo-bureau-neuke"),
                    new AnswerScore(0, "Ja, www.telegram.com"),
                    new AnswerScore(0, "Ja"),
                    new AnswerScore(0, "Onbekend"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Ja, Google"),
                    new AnswerScore(0, "Geen"),
                    new AnswerScore(0, "800 miljoen"),
                    new AnswerScore(0, "Pavel Durov"),
                    new AnswerScore(0, "Pavel Durov"),
                    new AnswerScore(0, "https://telegram.org/support"),
                    new AnswerScore(0, "Rusland")
            ),
            "Tumblr", List.of(
                    new AnswerScore(1, "nvt, rol technologie (controle)]"),
                    new AnswerScore(1, "Ja, 2019"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Nvt"),
                    new AnswerScore(0, "Nvt"),
                    new AnswerScore(0, "Gabb, 29-8-2022, Engels, https://gabb.com/blog/is-tumblr-safe/"),
                    new AnswerScore(0, "Ja, www.tumblr.com"),
                    new AnswerScore(0, "Ja"),
                    new AnswerScore(0, "Onbekend"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Nee"),
                    new AnswerScore(0, "Ja, Google"),
                    new AnswerScore(0, "Geen"),
                    new AnswerScore(0, "135 miljoen"),
                    new AnswerScore(0, "Automattic"),
                    new AnswerScore(0, "Automattic"),
                    new AnswerScore(0, "https://www.tumblr.com/contact_us"),
                    new AnswerScore(0, "Verenigde Staten")
            )
    );

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PlatformRepository platformRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    private void saveTestData() {
        Role admin = createRole("ADMIN", LEZEN, DOMEIN_BEHEER_ADMIN, DOMEIN_BEHEER_FICTER, BEHEER_GEBRUIKERS, BEHEER_ROLLEN);
        Role ficter = createRole("FICTER", LEZEN, DOMEIN_BEHEER_FICTER);
        Role readonly = createRole("READONLY", LEZEN);
/*
    READONLY(
            LEZEN),
    FICTER(
            LEZEN,
            DOMEIN_BEHEER_FICTER),
    ADMIN(
            LEZEN,
            DOMEIN_BEHEER_ADMIN,
            DOMEIN_BEHEER_FICTER,
            BEHEER_GEBRUIKERS,
            BEHEER_ROLLEN);

 */
        createUser("Sebastiaan", "Landers", "spineadmin2024", "12345@spine.com", admin);
        createUser("Shivane", "Frauenfelder", "spineficter2024", "12345@spine.com", ficter);
        createUser("Floris", "Admiraal", "spinereadonly2024", "12345@spine.com", readonly);
        Platform twitter = createPlatform("Twitter");
        Platform facebook = createPlatform("Facebook");
        Platform instagram = createPlatform("Instagram");
        Platform snapchat = createPlatform("Snapchat");
        Platform tiktok = createPlatform("Tiktok");
        Platform youtube = createPlatform("YouTube");
        Platform whatsapp = createPlatform("Whatsapp");
        Platform wechat = createPlatform("Wechat");
        Platform telegram = createPlatform("Telegram");
        Platform tumblr = createPlatform("Tumblr");

        List<Platform> platforms = List.of(twitter, facebook, instagram, snapchat, tiktok, youtube, whatsapp, wechat, telegram,
                tumblr
        );
        platforms.forEach(this::createQuestionsAndAnswers);
    }

    private Role createRole(String name, Permission... permissions) {
        Role role = new Role();
        role.setName(name);
        Arrays.stream(permissions).forEach(permission -> {
            role.getPermissions().add(permission);
        });
        return roleRepository.save(role);
    }

    private void createQuestionsAndAnswers(Platform platform) {
        int position = 0;
        List<AnswerScore> answers = ANSWERS.get(platform.getPlatformName());
        for (String questionText : QUESTIONS) {
            Question question = createQuestion(platform, questionText);
            AnswerScore answerScore = answers.get(position);
            createAnswer(question, answerScore.getText(), answerScore.getScore());
            position++;
        }
    }

    private void createUser(String firstName, String lastName, String email, String password, Role role) {
        var user = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(role)
                .build();
        userRepository.save(user);
    }

    private Platform createPlatform(String platformName){
        var platform = Platform.builder()
                .platformName(platformName).build();
        platformRepository.save(platform);
        return platform;
    }

    private Question createQuestion(Platform platform, String textQuestion){
        var question = Question.builder()
                .platform(platform)
                .textQuestion(textQuestion)
                .build();
        return questionRepository.save(question);
    }

    private Answer createAnswer(Question question, String textAnswer, int score) {
        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setTextAnswer(textAnswer);
        answer.setScore(score);
        return answerRepository.save(answer);
    }
}
