package com.zavanton.appactionsdemo.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.zavanton.appactionsdemo.R
import com.zavanton.appactionsdemo.databinding.FragmentPaymentBinding

class PaymentFragment : Fragment() {

    companion object {

        private const val MODE = "MODE"
        private const val VALUE = "VALUE"
        private const val CURRENCY = "CURRENCY"
        private const val ORIGIN = "ORIGIN"
        private const val DESTINATION = "DESTINATION"
        private const val ORIGIN_PROVIDER = "ORIGIN_PROVIDER"
        private const val DESTINATION_PROVIDER = "DESTINATION_PROVIDER"

        fun newInstance(
            transferMode: String,
            transferValue: String,
            transferCurrency: String,
            transferOrigin: String,
            transferDestination: String,
            transferOriginProvider: String,
            transferDestinationProvider: String
        ): PaymentFragment {
            return PaymentFragment().also { fragment ->
                fragment.arguments = Bundle().apply {
                    putString(MODE, transferMode)
                    putString(VALUE, transferValue)
                    putString(CURRENCY, transferCurrency)
                    putString(ORIGIN, transferOrigin)
                    putString(DESTINATION, transferDestination)
                    putString(ORIGIN_PROVIDER, transferOriginProvider)
                    putString(DESTINATION_PROVIDER, transferDestinationProvider)
                }
            }
        }
    }

    private lateinit var binding: FragmentPaymentBinding

    private val amount by lazy { arguments?.getString(VALUE).orEmpty() }
    private val mode by lazy { arguments?.getString(MODE).orEmpty() }
    private val currency by lazy { arguments?.getString(CURRENCY).orEmpty() }
    private val origin by lazy { arguments?.getString(ORIGIN).orEmpty() }
    private val destination by lazy { arguments?.getString(DESTINATION).orEmpty() }
    private val originProvider by lazy { arguments?.getString(ORIGIN_PROVIDER).orEmpty() }
    private val destinationProvider by lazy { arguments?.getString(DESTINATION_PROVIDER).orEmpty() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_payment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvAmount.text = getString(R.string.transfer_value, amount)
        binding.tvMode.text = getString(R.string.transfer_mode, mode)
        binding.tvCurrency.text = getString(R.string.transfer_currency, currency)
        binding.tvOrigin.text = getString(R.string.transfer_origin, origin)
        binding.tvDestination.text = getString(R.string.transfer_destination, destination)
        binding.tvOriginProvider.text = getString(R.string.transfer_origin_provider, originProvider)
        binding.tvDestinationProvider.text = getString(R.string.transfer_destination_provider, destinationProvider)
    }
}
