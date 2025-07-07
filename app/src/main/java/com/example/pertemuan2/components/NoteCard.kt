package com.example.pertemuan2.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pertemuan2.model.response.NoteItem


@Composable
fun NoteCard(
    note: NoteItem
) {
    // Pastel color
    val pastelSand = Color(0xFFF5E0A1)
    val pastelPink = Color(0xFFF8BBD0)
    val pastelLavender = Color(0xFFE1BEE7)
    val pastelPeach = Color(0xFFFFCC80)

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = pastelSand
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
            pressedElevation = 4.dp
        )
    ) {
        Box {
            // Gradient background accent
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                pastelPink,
                                pastelLavender,
                                pastelPeach
                            )
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .padding(top = 4.dp)
            ) {
                // title
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = note.title,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            color = Color(0xFF4A4A4A), // Dark gray untuk kontras yang baik
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Author info
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            Color(0xFFFFEB3B)
                        )
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Author",
                        modifier = Modifier.size(16.dp),
                        tint = Color(0xFF009688)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = note.nm_lengkap,
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight.Medium
                        ),
                        color = Color(0xFF009688)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Content
                Text(
                    text = note.content,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 15.sp,
                        lineHeight = 22.sp
                    ),
                    color = Color(0xFF5D4037).copy(alpha = 0.8f), // Brown untuk content text
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )

                // Subtle bottom accent
                Spacer(modifier = Modifier.height(12.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color(0xFFE1BEE7).copy(alpha = 0.6f), // Pastel purple untuk accent line
                                    Color.Transparent
                                )
                            )
                        )
                )
            }
        }
    }
}