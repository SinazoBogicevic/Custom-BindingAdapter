package android.example.custombindingadapters.data

import android.example.custombindingadapters.Medal
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {
    /**
     * Use MutableLiveData because it can be modified however we send LiveData
     * to our UI because it cannot be modified accidenltly
     */

    private val _heading = MutableLiveData("Begin")
    private val _position = MutableLiveData(0)

    val heading: LiveData<String> = _heading
    val position: LiveData<Int> = _position
    val medal: LiveData<Medal> = Transformations.map(_position){
        when {
            it > 15 -> Medal.BADGE
            it > 10  -> Medal.BRONZE
            it > 5 -> Medal.SILVER
            it > 1 -> Medal.GOLD
            else -> Medal.START
        }
    }

    /**
     * increments the position
     * value property gets/sets the LiveData
     */

    fun onPosition(){
        _position.value = (_position.value ?: 0) + 1
    }



}
