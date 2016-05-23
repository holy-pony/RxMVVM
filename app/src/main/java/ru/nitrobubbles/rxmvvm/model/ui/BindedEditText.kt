package ru.nitrobubbles.rxmvvm.model.ui

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.widget.EditText
import ru.nitrobubbles.rxmvvm.model.Model
import ru.nitrobubbles.rxmvvm.model.ModelStorage
import ru.nitrobubbles.rxmvvm.model.ViewModel

/**
 * Created by konstantinaksenov on 23.05.16.
 */
class BindedEditText : ViewModel {

    var model : Model? = null
    override fun modelHasUpdate(model: Model) {
        this.model = model
    }

    var editText: EditText? = null

    constructor(context: Context?) : super(context) {
        build()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        build()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        build()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        build()
    }

    fun build() {
        editText = EditText(context)
        addView(editText)
        editText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                model?.text = s.toString()
                if(model != null) {
                    updateModel(model!!)
                }
            }
        })
    }


}