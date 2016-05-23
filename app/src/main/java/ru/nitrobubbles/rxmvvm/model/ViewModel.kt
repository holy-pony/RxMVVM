package ru.nitrobubbles.rxmvvm.model

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import rx.android.schedulers.AndroidSchedulers
import rx.subscriptions.CompositeSubscription

/**
 * Created by konstantinaksenov on 23.05.16.
 */
abstract class ViewModel : FrameLayout {
    var compositeSubscription: CompositeSubscription? = null

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        compositeSubscription?.unsubscribe()
        compositeSubscription = CompositeSubscription()
        compositeSubscription?.add(ModelStorage
                .modelBehaivorSubject
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ modelHasUpdate(it) }))
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        compositeSubscription?.unsubscribe()
    }

    fun updateModel(model: Model) {
        ModelStorage.setModel(model)
    }

    abstract fun modelHasUpdate(model: Model)
}