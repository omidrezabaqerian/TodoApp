package com.omidrezabagherian.todoapplication.ui.insert

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.omidrezabagherian.todoapplication.R
import com.omidrezabagherian.todoapplication.data.model.Condition
import com.omidrezabagherian.todoapplication.data.model.Part
import com.omidrezabagherian.todoapplication.data.model.Part.*
import com.omidrezabagherian.todoapplication.data.model.State
import com.omidrezabagherian.todoapplication.data.model.State.*
import com.omidrezabagherian.todoapplication.data.model.Todo
import com.omidrezabagherian.todoapplication.databinding.FragmentInsertBinding
import java.util.*

class InsertFragment : Fragment(R.layout.fragment_insert) {

    private lateinit var insertBinding: FragmentInsertBinding
    private val insertViewModel: InsertViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        insertBinding = FragmentInsertBinding.bind(view)

        insertBinding.buttonSetDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)


            val datePickerDialog = DatePickerDialog(
                requireActivity(),
                { _, year, monthOfYear, dayOfMonth ->
                    val date = "${1 + monthOfYear}/$dayOfMonth/$year"
                    insertBinding.textInputEditTextInsertDate.setText(date)
                },
                year,
                month,
                day
            )

            datePickerDialog.show()
        }

        insertBinding.buttonSetSend.setOnClickListener {
            val todo = Todo(
                0,
                "omidreza",
                insertBinding.textInputEditTextInsertTitle.text.toString(),
                insertBinding.textInputEditTextInsertDate.text.toString(),
                insertBinding.textInputEditTextInsertDate.text.toString(),
                getPart(insertBinding.spinnerPartInsert.selectedItem.toString()),
                getState(insertBinding.spinnerStateInsert.selectedItem.toString()),
                Condition.New
            )

            insertViewModel.insertTodo(todo)
        }

    }

    private fun getPart(Part: String): Part {
        return when (Part) {
            "کار های من" -> Todo
            "در حال انجام" -> Doing
            "کار های تکمیل شده" -> Done
            else -> Todo
        }
    }

    private fun getState(state: String): State {
        return when (state) {
            "پایین" -> Low
            "متوسط" -> Medium
            "بالا" -> High
            else -> Low
        }
    }
}