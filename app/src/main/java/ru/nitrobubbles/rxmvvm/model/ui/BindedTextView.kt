package ru.nitrobubbles.rxmvvm.model.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import ru.nitrobubbles.rxmvvm.model.Model
import ru.nitrobubbles.rxmvvm.model.ViewModel

/**
 * Created by konstantinaksenov on 23.05.16.
 */
class BindedTextView : ViewModel {
    var textView : TextView? = null

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
        textView = TextView(context)
        addView(textView)
    }

    override fun modelHasUpdate(model: Model) {
        textView?.text = model.text
    }

}