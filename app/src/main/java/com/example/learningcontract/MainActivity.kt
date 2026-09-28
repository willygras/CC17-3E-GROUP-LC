package com.example.learningcontract

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.PrimaryScrollableTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningcontract.ui.theme.LearningContractTheme

data class LearningContractData(
    val id: Int,
    val fullName: String,
    val shortName: String,
    val expectations: String,
    val motivations: String,
    val contributions: String,
    val hindrances: String
)

val summaryData = LearningContractData(
    id = 0,
    fullName = "CC17 Group Summary",
    shortName = "Summary",
    expectations = "Overall, we expect this course to teach us the knowledge and practical skills needed to properly design and develop mobile applications. We also expect clear guidance from our instructor, meaningful activities, and lessons that can be applied to future work and real-world situations.",
    motivations = "We are motivated to pass and complete the course so we can graduate on time and prepare ourselves for future careers. We also want to gain useful technical skills, improve our confidence and problem-solving abilities, and eventually create functional projects that can be useful in our careers.",
    contributions = "We will contribute by being attentive and participating actively in class discussions and activities. We will complete our requirements on time, practice the skills we learn, ask questions when needed, help our classmates, and cooperate with our instructor and group members throughout the course.",
    hindrances = "Some of the challenges we may face include procrastination, poor time management, distractions, lack of focus, and difficulty understanding certain technical concepts. External problems such as illness, bad weather, power interruptions, and unstable internet may also affect our attendance, participation, and ability to complete requirements."
)

val membersList = listOf(
    LearningContractData(
        id = 1,
        fullName = "Aurelia Lois Ang Wani",
        shortName = "Aurelia",
        expectations = "In this course, I expect that we will learn about mobile applications. Mobile app designing is also expected. To better understand these things, I expect for the instructor to elaborate and clarify everything about this subject. I also expect that the activities are quite difficult. However, I expect that I can pass this subject.",
        motivations = "Being able to graduate on time is one of my motivations. Another motivation is also to have a passing grade. Aside from these first two, another motivation of mine is to have a stable work soon. As a daughter, my biggest motivation is to help my family financially. Last but not the least, being able to travel with my beloved ones is another biggest motivation.",
        contributions = "To pass this course, I will try my best in submitting all the activities. Also, I will reduce or avoid absents and tardiness. I will also try to boost my confidence to ask some questions if something is not clarified. I will also participate in any activities. Lastly, I will try my best to listen during lectures.",
        hindrances = "I will not be able to fulfill all my expectations, contributions and will not achieve my motivations due to hindrances such as being a lazy person. Another obstacle is the frequent power interruption and low internet. As a Gen-z, being easily distracted to social media is a biggest hindrance. Aside from those things, I also have no fixed study schedule. Additionally, I lack time management."
    ),
    LearningContractData(
        id = 2,
        fullName = "Lady Queenie Centeno",
        shortName = "Lady Queenie",
        expectations = "I expect my groupmates and me to be able to create a functioning mobile application from ideation to deployment that fits the guidelines. I hope to learn the whole process of it, especially the coding part rather than just the document. I also expect to have an organized, well-written and visually presentable documentation. Of course, I also hope to be instilled with necessary knowledge and skills that I need for my future work if ever it's included in the job description of the position that I will be applying for. Lastly, I expect that our kind instructor will guide us throughout the entire development process and to have an enjoyable experience with my classmates as well.",
        motivations = "My main motivation is my family, the people that stayed despite my sadness, and the ones that keep on believing I can. They are the reason why I persevere to gain the knowledge and skills that I need to be capable enough in my chosen field. I want to have technical confidence, because it has always been something I feel anxious about. Despite all those jittery feelings, I'm excited to create and see our functional mobile application that feels and looks good, as I value aesthetics-which also implies our document. I like things to look neat or have visual harmony that tells a story just by seeing it, and more in exploring it.",
        contributions = "I will attend classes, listen attentively, take notes, do my best in every deliverable or activity, and ask questions. I will participate in every class discussion by doing all those efforts, also by answering questions asked in discussions and sharing my ideas. And for our final project or course itself, I will put into use my IT-ERP skills, by finding what's wrong and connecting each problem to practical solutions. With that, my creative and perfectionist side will come in, it'll contribute an aesthetic ui/ux and document which both fits the criteria. Lastly, I will communicate clearly, do my part and step up when needed, embrace constructive feedback from our instructor, and respect my team's efforts and input.",
        hindrances = "Sickness or unexpected personal situations may prevent me from attending classes, participating in activities, or giving my best overall. Limited time can also play a big role, especially when all or most of my enrolled subjects give heavy workloads with close deadlines all at the same time. Another hindrance is the weather, due to constant rain, it can be dangerous to go to school as there are lots of landslides happening. There will also be unexpected moments where technical difficulties will occur, such as power interruptions or sudden internet crashes, which will also affect my ability to submit activities on time. I may also struggle when I cannot fully understand a concept or technical problem within the allotted time, especially when an error is difficult to identify."
    ),
    LearningContractData(
        id = 3,
        fullName = "Ralvin Jay Magalong",
        shortName = "Ralvin Jay",
        expectations = "I expect the lectures to be interesting and provide enough information about mobile app development. I expect the teacher to clearly explain the concepts, coding techniques, and other topics while allowing us to ask questions when needed. I also expect the class to actively participate and cooperate during discussions and activities. As a student, I expect myself to listen attentively and make an effort to understand the topics discussed. Lastly, I expect the course to provide lessons and activities that can be applied to real-world mobile applications and development.",
        motivations = "My motivation for taking this course is to graduate and successfully complete the requirements for Mobile App Development. I want to gain knowledge and skills that can help me find and maintain a good job in the future. I also want to develop mobile app development skills that I can use in future projects, school activities, and work. Another motivation is to successfully pass the course and avoid falling behind in the lessons. Most importantly, I want to improve my ability to analyze problems and create effective solutions when developing mobile applications.",
        contributions = "I will contribute to the class by being attentive and actively participating in discussions and activities. I will also try to help my classmates whenever they need assistance with topics or activities related to mobile app development. I will make an effort to submit activities and requirements on time and attend classes without being late. I will cooperate with my classmates and professor during group activities, discussions, and projects. I will also keep an open mind toward feedback and different approaches to mobile app development.",
        hindrances = "Some hindrances I may encounter during this course include sleepiness or lack of energy during lectures and development activities. My tendency to procrastinate may also affect my ability to complete coding activities and projects on time. I may also lose focus easily, especially during long discussions or when working on difficult development tasks. Any illness that affects my ability to participate and perform may also become a hindrance during the course. Lastly, unexpected inconveniences such as accidents, power outages, or loss of internet connection may affect my ability to attend classes or complete activities."
    ),
    LearningContractData(
        id = 4,
        fullName = "William Garcia",
        shortName = "William",
        expectations = "I expect to learn how to properly create a mobile application. I expect to apply what I learn in my future work. I expect to do my best in this course to improve decision-making skills. I expect that my project can also be something I am able to include in my resume. I expect that our instructor will do their best to nourish us with knowledge in this course.",
        motivations = "My passion to learn and perform well. Knowing that my future will need the insight and knowledge from this course. In order to prepare myself for my future self so I can live a stable and happy life. My natural interest in tech as a kid. My desire to develop and launch a fully functioning project.",
        contributions = "I will review the different lessons I will encounter in my course. I will listen well to my instructor. I will learn and practice if needed in order to get better at the skills in this course. I will ask questions and request consultations regarding our project. I will make sure that I will always do my best in this course and every other course I encounter.",
        hindrances = "There are times when I have poor time management skills. During online classes, unstable internet connections can occur randomly. I tend to get easily distracted sometimes. When I do not clarify confusing topics, leaving me clueless about different subjects. My tendency to cram schoolwork on the due date."
    )
)

val navTitles = listOf(
    "Summary",
    "Aurelia Lois Ang Wani",
    "Lady Queenie Centeno",
    "Ralvin Jay Magalong",
    "William Garcia"
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningContractTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var selectedTab by remember { mutableIntStateOf(0) }
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            Column {
                CenterAlignedTopAppBar(
                    title = {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "CC17 Learning Contract",
                                style = MaterialTheme.typography.titleLarge.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                ),
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                            Text(
                                text = "Applications Development & Emerging Technologies",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.85f)
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                )

                // Top Scrollable Navigation Bar with Exact Required Names
                PrimaryScrollableTabRow(
                    selectedTabIndex = selectedTab,
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    edgePadding = 16.dp
                ) {
                    navTitles.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTab == index,
                            onClick = { selectedTab = index },
                            text = {
                                Text(
                                    text = title,
                                    style = MaterialTheme.typography.labelLarge.copy(
                                        fontWeight = if (selectedTab == index) FontWeight.Bold else FontWeight.Medium
                                    ),
                                    color = if (selectedTab == index)
                                        MaterialTheme.colorScheme.primary
                                    else
                                        MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            },
                            icon = {
                                Icon(
                                    imageVector = if (index == 0) Icons.AutoMirrored.Filled.MenuBook else Icons.Default.Person,
                                    contentDescription = title,
                                    tint = if (selectedTab == index)
                                        MaterialTheme.colorScheme.primary
                                    else
                                        MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
                                )
                            }
                        )
                    }
                }
            }
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                tonalElevation = 8.dp
            ) {
                navTitles.forEachIndexed { index, title ->
                    val shortLabel = when (index) {
                        0 -> "Summary"
                        1 -> "Aurelia"
                        2 -> "Lady Queenie"
                        3 -> "Ralvin Jay"
                        4 -> "William"
                        else -> title
                    }
                    NavigationBarItem(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        icon = {
                            Icon(
                                imageVector = if (index == 0) Icons.AutoMirrored.Filled.MenuBook else Icons.Default.Person,
                                contentDescription = title
                            )
                        },
                        label = { Text(shortLabel, fontSize = 11.sp) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            indicatorColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(scrollState)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Course Info Header Card
            CourseHeaderCard()

            if (selectedTab == 0) {
                // SUMMARY SECTION
                Text(
                    text = "Summary Overview — CC17 Learning Contract",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
                )

                // Group Summary Card from summary.md
                ContractCard(data = summaryData, isSummary = true)

                // Overview of Team Members
                Text(
                    text = "Team Members Contracts Overview",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                )

                membersList.forEach { member ->
                    ContractCard(data = member, isSummary = false)
                }

                // Signers Section
                SignersSection()
            } else {
                // INDIVIDUAL MEMBER SECTION
                val selectedMember = membersList.getOrNull(selectedTab - 1)
                selectedMember?.let { member ->
                    Text(
                        text = "Individual Learning Contract",
                        style = MaterialTheme.typography.labelLarge.copy(
                            color = MaterialTheme.colorScheme.secondary,
                            fontWeight = FontWeight.SemiBold
                        )
                    )

                    ContractCard(data = member, isSummary = false)

                    Spacer(modifier = Modifier.height(8.dp))

                    // Quick Signer Confirmation Badge
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        ),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Group,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(
                                    text = "Confirmed Signer",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
                                )
                                Text(
                                    text = member.fullName,
                                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun CourseHeaderCard() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Text(
                    text = "COURSE CODE: CC17",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    ),
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                )
            }
            Text(
                text = "Group Learning Contract",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                ),
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                textAlign = TextAlign.Center
            )
            Text(
                text = "This contract outlines our collective and individual expectations, motivations, contributions, and hindrances for CC17 Mobile Application Development.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.85f),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 6.dp)
            )
        }
    }
}

@Composable
fun ContractCard(data: LearningContractData, isSummary: Boolean) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = if (isSummary) MaterialTheme.colorScheme.secondaryContainer else MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isSummary) 4.dp else 2.dp),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Header Title
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (isSummary) "S" else data.shortName.take(1),
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = data.fullName,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp,
                            color = if (isSummary) MaterialTheme.colorScheme.onSecondaryContainer else MaterialTheme.colorScheme.onSurface
                        )
                    )
                    Text(
                        text = if (isSummary) "Consolidated Group Overview — CC17" else "Team Member — CC17",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }

            SectionParagraph(
                title = "Expectations",
                content = data.expectations
            )

            SectionParagraph(
                title = "Motivations",
                content = data.motivations
            )

            SectionParagraph(
                title = "Contributions",
                content = data.contributions
            )

            SectionParagraph(
                title = "Hindrances",
                content = data.hindrances
            )
        }
    }
}

@Composable
fun SectionParagraph(title: String, content: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(12.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = content,
            style = MaterialTheme.typography.bodyMedium.copy(
                lineHeight = 20.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        )
    }
}

@Composable
fun SignersSection() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Contract Signers",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            )
            Text(
                text = "By consensus, the following team members sign and confirm this Learning Contract:",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.8f),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 4.dp, bottom = 12.dp)
            )

            membersList.forEach { member ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = member.fullName,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    LearningContractTheme {
        MainScreen()
    }
}