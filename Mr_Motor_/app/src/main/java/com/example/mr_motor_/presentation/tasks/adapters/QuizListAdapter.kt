package com.example.mr_motor_.presentation.tasks.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mr_motor_.R
import com.example.mr_motor_.domain.models.quiz.ShortQuizVO
import com.example.mr_motor_.presentation.tasks.diffcallbacks.QuizDiffCallback
import com.example.mr_motor_.presentation.tasks.fullQuiz.QuizDescriptionPage

class QuizListAdapter(context: Context?) : ListAdapter<ShortQuizVO, QuizListAdapter.QuizViewHolder>(QuizDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.quizespage_viewholder, parent, false)
        return QuizViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class QuizViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val title : TextView = itemView.findViewById(R.id.tv_quizViewHolder_title)
        private val image : ImageView = itemView.findViewById(R.id.iv_quizViewHolder_image)
        private val view : View = itemView.findViewById(R.id.v_view)
        private lateinit var quiz : ShortQuizVO
        fun bind(quiz: ShortQuizVO){
            this.quiz = quiz
            title.text = quiz.title
            when {
                (quiz.id % 3) == (0).toLong() -> {
                    image.setImageResource(R.drawable.sport_car)
                }
                (quiz.id % 3) == (1).toLong() -> {
                    image.setImageResource(R.drawable.ic_racer)
                }
                (quiz.id % 3) == (2).toLong() -> {
                    image.setImageResource(R.drawable.ic_cup)
                }
            }
            when {
                (quiz.id % 5) == (0).toLong() -> {
                    view.setBackgroundResource(R.color.red)
                }
                (quiz.id % 5) == (1).toLong() -> {
                    view.setBackgroundResource(R.color.mint_green)
                }
                (quiz.id % 5) == (2).toLong() -> {
                    view.setBackgroundResource(R.color.light_blue)
                }
                (quiz.id % 5) == (3).toLong() -> {
                    view.setBackgroundResource(R.color.purple)
                }
                (quiz.id % 5) == (4).toLong() -> {
                    view.setBackgroundResource(R.color.light_orange)
                }
            }
        }
        init {
            itemView.setOnClickListener {
                QuizDescriptionPage.start(itemView.context as Activity, quiz)
            }
        }
    }
}