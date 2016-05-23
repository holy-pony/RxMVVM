package ru.nitrobubbles.rxmvvm.model

import rx.subjects.BehaviorSubject

/**
 * Created by konstantinaksenov on 23.05.16.
 */
object ModelStorage{
    val modelBehaivorSubject = BehaviorSubject.create<Model>(Model())

    fun setModel(model :Model){
        modelBehaivorSubject.onNext(model)
    }
}